package com.epam.mjc.nio;

import java.io.File;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        String nameLine = "";
        String ageLine = "";
        String emailLine = "";
        String phoneLine = "";
        try {
            InputStream input = Files.newInputStream(Path.of(file.getPath()));

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            nameLine = reader.readLine();
            ageLine = reader.readLine();
            emailLine = reader.readLine();
            phoneLine = reader.readLine();

            String deleteName = "Name: ";
            String deleteAge = "Age: ";
            String deleteEmail = "Email: ";
            String deletePhone = "Phone: ";

            nameLine = nameLine.replace(deleteName, "");
            ageLine = ageLine.replace(deleteAge, "");
            emailLine = emailLine.replace(deleteEmail, "");
            phoneLine = phoneLine.replace(deletePhone, "");
        } catch (IOException e) {
            e.getMessage();
        }
        profile.setName(nameLine);
        try {
            profile.setAge(Integer.parseInt(ageLine.trim()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        profile.setEmail(emailLine);
        try {
            profile.setPhone(Long.parseLong(phoneLine.trim()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
