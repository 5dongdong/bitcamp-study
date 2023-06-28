package bitcamp2.myapp.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStream extends FileInputStream {

  public DataInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  public short readShort() throws IOException {
    return (short) (this.read() << 8 | this.read());
  }

  public int readInt() throws IOException {
    return (this.read() << 24 | this.read() << 16 | this.read() << 8 | this.read());
  }

  public long readLong() throws IOException {
    return (long) this.read() << 56 | this.read() << 48 | this.read() << 40 | this.read() << 32
        | this.read() << 24 | this.read() << 16 | this.read() << 8 | this.read();
  }

  public char readChar() throws IOException {
    return (char) (this.read() << 8 | this.read());
  }

  public String readUTF() throws IOException {
    int length = this.read() << 8 | this.read();
    byte[] buf = new byte[length];
    this.read(buf);
    return new String(buf, "UTF-8");
  }
}
