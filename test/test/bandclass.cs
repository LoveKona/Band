using System;
using System.IO;
using System.Net;
using System.Security.Cryptography;
using System.Text;
using System.Text.RegularExpressions;
namespace test
{
    class BandClass
    {
        public static string base_url;

        public static string api_version;

        public static string api_url;

        public string me2_application_key = "bcb6d11b685d94a08f5b1965896b50c8";

        public string sign_key = "de68d80d34ec9e30c7a5120fbd7ee829";

        static BandClass()
        {
            BandClass.base_url = "https://api.band.us/";
            BandClass.api_version = "v1/";
            BandClass.api_url = string.Concat(BandClass.base_url, BandClass.api_version);
        }

        public BandClass()
        {
        }

        public string getAppSign()
        {
            DateTime dateTime = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
            int totalMilliseconds = (int)((long)(DateTime.UtcNow - dateTime).TotalMilliseconds);
            string str = string.Concat(totalMilliseconds.ToString(), "ffffffff", this.me2_application_key, this.sign_key);
            MD5 mD5 = MD5.Create();
            byte[] numArray = mD5.ComputeHash(Encoding.UTF8.GetBytes(str));
            string str1 = string.Concat(totalMilliseconds.ToString(), "$$ffffffff$$", BitConverter.ToString(numArray).Replace("-", string.Empty).ToLower());
            return Convert.ToBase64String(Encoding.UTF8.GetBytes(str1));
        }
        public string getFullAuthToken() // (string UserID)
        {
            string userid = "konachan@nate.com"; // UserID;
            string token = GetToken();
            string auth = userid + ":full_auth_token " + token;
            string result ="Basic "+ Convert.ToBase64String(Encoding.UTF8.GetBytes(auth));
            return result;
        }

        public string GetToken()
        {
            HttpWebRequest httpWebRequest = (HttpWebRequest)WebRequest.Create("https://api.band.us/v1/get_start_token");
            httpWebRequest.Headers.Add("me2_application_key", this.me2_application_key);
            httpWebRequest.Headers.Add("version", "20151216");
            httpWebRequest.Headers.Add("locale", "ko-KR");
            httpWebRequest.Headers.Add("user_locale", "ko-KR_KR");
            httpWebRequest.Headers.Add("me2_asig", this.getAppSign());
            httpWebRequest.Headers.Add("language", "ko");
            httpWebRequest.UserAgent = "BAND/5.0.3 (iPhone OS 9.2; iPhone7,1)";
            httpWebRequest.Headers.Add("country", "KR");
            HttpWebResponse response = (HttpWebResponse)httpWebRequest.GetResponse();
            if (response.StatusCode != HttpStatusCode.OK)
            {
                return "";
            }
            string end = (new StreamReader(response.GetResponseStream())).ReadToEnd();
            if (!end.Contains("result_code\":1"))
            {
                return "";
            }
            File.WriteAllText("test.txt", end);
            Match match = (new Regex("\"token\":\"(.*?)\"")).Match(end);
            return match.Groups[1].Value;
        }
    }
}
