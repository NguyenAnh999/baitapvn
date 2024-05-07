package util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FireBase {
    public static Storage getStorage() throws IOException {
        return new FireBase().storage();
    }
    private FireBase(){

    }
    public Storage storage() throws IOException {
//        InputStream inputStream = getClass().getResourceAsStream("firebase-config.json");
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("firebase-config.json");
        FileInputStream inputStream = new FileInputStream("C:\\javacode\\servlet-jsp-demo-main\\src\\main\\resources\\firebase-config.json");
        return StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .build()
                .getService();
    }

//    public static void main(String[] args) throws IOException {
//        Storage storage = FireBase.getStorage();
//        Path localPath = Paths.get("C:\\Users\\chjck\\Downloads\\OI P.jpg"); // lấy ra đối tượng Paths của ảnh vừa upload lên server
//        String fileName = localPath.getFileName().toString(); // lấy ra tên file upload
//
//        BlobId blobId = BlobId.of( "ra-hoctap.appspot.com", fileName); // tạo file trên storage bằng tên và bucketname chỉ đinh
//
//        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
//        // Thiết lập quyền truy cập công cộng
//        List<Acl> acls = new ArrayList<>();
//        acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
//        blobInfo = blobInfo.toBuilder().setAcl(acls).build();
//        try {
//            Blob blob = storage.create(blobInfo, Files.readAllBytes(localPath));
//            System.out.println( blob.getMediaLink()); // trả về đường dẫn ảnh online
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
