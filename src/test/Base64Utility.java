package test;

import java.io.ByteArrayInputStream;

public class Base64Utility
{
  static final char[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  static final int[] b = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0, 0, 0, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  private boolean c = true;
  
  public Base64Utility()
  {
    this(true);
  }
  
  public Base64Utility(boolean paramBoolean)
  {
    setCRLF(paramBoolean);
  }
  
  public String encode(String paramString)
  {
    return encode(paramString.getBytes());
  }
  
  public String encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    int j = 0;
    int i = 0;
    if (j < paramArrayOfByte.length)
    {
      int i2 = localByteArrayInputStream.read();
      int n = localByteArrayInputStream.read();
      int i1 = localByteArrayInputStream.read();
      int m =0;
      int k =0;
      if (n == -1)
      {
        i = 2;
        m = 0;
        k = i1;
      }
      for (;;)
      {
        k = k << 0 & 0xFF | m << 8 & 0xFF00 | i2 << 16 & 0xFF0000;
        localStringBuffer.append(a[(k >> 18 & 0x3F)]);
        localStringBuffer.append(a[(k >> 12 & 0x3F)]);
        localStringBuffer.append(a[(k >> 6 & 0x3F)]);
        localStringBuffer.append(a[(k >> 0 & 0x3F)]);
        if (((j + 3) % 57 == 0) && (this.c)) {
          localStringBuffer.append('\n');
        }
        j += 3;
        break;
      }
    }
    j = localStringBuffer.length();
    while (i > 0)
    {
      localStringBuffer.setCharAt(j - i, '=');
      i -= 1;
    }
    if (this.c) {
      localStringBuffer.append('\n');
    }
    return localStringBuffer.toString();
  }
  
  public void setCRLF(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}
