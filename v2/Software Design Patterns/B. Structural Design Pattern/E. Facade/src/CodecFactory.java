public class CodecFactory {
    public static CodecType extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodeFactory: Extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodeFactory: Extracting ogg audio...");
            return new OggCompressionType();
        }
    }
}
