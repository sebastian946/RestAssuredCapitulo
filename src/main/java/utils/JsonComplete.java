package utils;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Locale;
import java.util.Random;

public class JsonComplete {
    public static JsonObject userComplete() throws FileNotFoundException {
        Gson gson = new Gson();
        Faker faker = new Faker(new Locale("es"),new Random(24));
        Reader reader = new FileReader("src/main/resources/user.json");
        JsonObject user = JsonParser.parseReader(reader).getAsJsonObject();
        user.addProperty("id",faker.idNumber().valid());
        user.addProperty("firstName",faker.name().firstName());
        user.addProperty("lastName",faker.name().lastName());
        JsonObject contactInfo = user.getAsJsonObject("contactInfo");
        contactInfo.addProperty("number",faker.phoneNumber().cellPhone());
        contactInfo.addProperty("email",faker.name().username()+"@gmail.com");
        contactInfo.addProperty("zip",faker.address().zipCode());
        return user;
    }
}
