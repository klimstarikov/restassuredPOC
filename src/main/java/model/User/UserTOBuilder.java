package model.User;

import model.*;

import java.util.List;

public class UserTOBuilder {
    private final UserTO user;

    public UserTOBuilder() {
        this.user = new UserTO();
        user.setId(1);
        user.setName("Leanne Graham");
        user.setUsername("Bret");
        user.setEmail("Sincere@april.biz");
        user.setPhone("1-770-736-8031 x56442");
        user.setWebsite("hildegard.org");

        AdressTO address = new AdressTO();
        address.setStreet("Kulas Light");
        address.setSuite("Apt. 556");
        address.setCity("Gwenborough");
        address.setZipcode("92998-3874");

        GeoTO geo = new GeoTO();
        geo.setLat("-37.3159");
        geo.setLng("81.1496");
        address.setGeo(geo);

        user.setAddress(address);

        CompanyTO company = new CompanyTO();
        company.setName("Romaguera-Crona");
        company.setCatchPhrase(new CatchPhraseVO(List.of(
                CatchPhraseComponent.MULTI_LAYERED,
                CatchPhraseComponent.CLIENT_SERVER,
                CatchPhraseComponent.NEURAL_NET))
                .asString());
        company.setBs("harness real-time e-markets");

        user.setCompany(company);
    }

    public UserTOBuilder withId(int id) {
        user.setId(id);
        return this;
    }

    public UserTOBuilder withUsername(String username) {
        user.setName(username);
        return this;
    }

    public UserTOBuilder withEmail(String email) {
        user.setEmail(email);
        return this;
    }

    public UserTOBuilder withPhone(String phone) {
        user.setPhone(phone);
        return this;
    }

    public UserTOBuilder withWebsite(String website) {
        user.setWebsite(website);
        return this;
    }

    public UserTOBuilder withAddress(AdressTO address) {
        user.setAddress(address);
        return this;
    }

    public UserTOBuilder withCompany(CompanyTO company) {
        user.setCompany(company);
        return this;
    }

    public UserTO build() {
        return user;
    }

}
