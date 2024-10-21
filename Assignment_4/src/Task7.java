import java.util.ArrayList;
import java.util.List;

class Document {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public DocumentVersion save() {
        return new DocumentVersion(content);
    }

    public void restore(DocumentVersion version) {
        this.content = version.getContent();
    }
}

class DocumentVersion {
    private final String content;

    public DocumentVersion(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class VersionControl {
    private List<DocumentVersion> versions = new ArrayList<>();

    public void saveVersion(DocumentVersion version) {
        versions.add(version);
    }

    public DocumentVersion getVersion(int index) {
        return versions.get(index);
    }

    public void listVersions() {
        for (int i = 0; i < versions.size(); i++) {
            System.out.println("Version " + i + ": " + versions.get(i).getContent());
        }
    }
}

public class Task7 {
    public static void main(String[] args) {
        Document doc = new Document();
        VersionControl vc = new VersionControl();

        doc.setContent("Version 1");
        vc.saveVersion(doc.save());

        doc.setContent("Version 2");
        vc.saveVersion(doc.save());

        doc.setContent("Version 3");

        vc.listVersions();

        doc.restore(vc.getVersion(1));
        System.out.println("Restored to: " + doc.getContent());
    }
}
