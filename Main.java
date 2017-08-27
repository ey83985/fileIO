package com.company;


import java.io.*;


class CSFile {
  String file;
  CSFile(String file) {
    this.file = file;
  }
  String get() {
    try(BufferedReader f = new BufferedReader(new FileReader(this.file))) {
      String c = null;
      String i;
      do {
        i = f.readLine() + "\n";
        if(i != null) c = c + i;
      } while(i != null);
      return c;
    }
    catch(IOException e) {
      System.out.println("IOException occurred: " + e);
      return null;
    }
  }
  boolean append(String text) {
    try(FileWriter f = new FileWriter(this.file, true)) {
      f.write(text);
      return true;
    }
    catch(IOException e) {
      System.out.println("IOException occurred: " + e);
      return false;
    }
  }
}

class RAFile {
  String file;
  RAFile(String file) {
    this.file = file;
  }
  char read(long pos) {
    try(RandomAccessFile f = new RandomAccessFile(this.file, "r")) {
      f.seek(pos);
      char c = (char) f.readByte();
      return c;
    }
    catch(IOException e) {
      System.out.println("IOException occurred: " + e);
      return null;
    }
  }
  boolean write(long pos, char value) {
    try(RandomAccessFile f = new RandomAccessFile(this.file, "rw")) {
      f.seek(pos);
      f.writeChar(value);
      return true;
    }
    catch(IOException e) {
      System.out.println("IOException occurred: " + e);
      return false;
    }
  }
}

public class Main {
  public static void main(String args[]) {
  }
}
