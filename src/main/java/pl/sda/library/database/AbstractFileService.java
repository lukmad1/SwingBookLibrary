package pl.sda.library.database;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFileService<T> {


    private String PATH;

    public AbstractFileService(String PATH) {
        this.PATH = PATH;
    }

    public void save(T t) throws IOException {
        String string = new Gson().toJson(t);
        File file = new File(this.PATH);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file, true);

        fileOutputStream.write(string.getBytes());
        fileOutputStream.write('\n');
        fileOutputStream.close();
    }

    public List<T> load() throws IOException {
        File file = new File(this.PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<T> tList = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            tList.add(unJson(line));
        }
        bufferedReader.close();

        return tList;
    }

    protected abstract T unJson(String str);

}
