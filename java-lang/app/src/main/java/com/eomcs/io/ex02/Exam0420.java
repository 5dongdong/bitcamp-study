// FileInputStream 활용 - JPEG 파일 읽기
package com.eomcs.io.ex02;

import java.io.File;

public class Exam0420 {

  public static void main(String[] args) throws Exception {

    // 1) 파일 정보를 준비한다.
    File file = new File("sample/photo1.jpg");
    
    Metadata metadata = ImageMetadataReader.readMetadata(file);
  }

}
