import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: Video conversion started...");
        VideoFile file = new VideoFile(fileName);
        CodecType sourceCodec = CodecFactory.extract(file);
        CodecType destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        }
        else {
            destinationCodec = new OggCompressionType();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediate = BitrateReader.write(buffer, destinationCodec);
        File result = new AudioMixer().mix(intermediate);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
