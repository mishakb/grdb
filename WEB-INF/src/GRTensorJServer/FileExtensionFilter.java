package GRTensorJServer;

import java.util.*;

class FileExtensionFilter implements java.io.FilenameFilter {
    private String extension = null;

    public FileExtensionFilter(String extension) {
        this.extension = extension;
    }

    public boolean accept(java.io.File dir, String name) {
        StringTokenizer tokenizer = new StringTokenizer(name,".");
        String extension = "";
        tokenizer.nextToken();
        while (tokenizer.hasMoreTokens()) {
            extension = tokenizer.nextToken();
        }
        if (extension.equals(this.extension) || extension.equals(this.extension.toUpperCase())) {
            return true;
        }
        else {
            return false;
        }
    }
}
