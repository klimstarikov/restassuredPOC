package tests.Positive;

import facade.PhotosAPIFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Photo.PhotoVO;
import model.Photo.PhotoVORequest;
import model.Photo.PhotoVORequestFactory;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Epic("Photo API Tests")
@Feature("Photo Feature")
public class PhotosTest extends BaseTest {
    private final PhotosAPIFacade photosAPIFacade = new PhotosAPIFacade();

    @Test
    @Story("Get photo by id")
    public void getPhotoById() {
        PhotoVO photo = photosAPIFacade.getPhotoById(1);
        Assert.assertEquals(photo.getId(), 1);
    }

    @Test
    @Story("Get photos by album id")
    public void getPhotosByAlbumId() {
        List<PhotoVO> photos = photosAPIFacade.getPhotosByAlbumId(1);
        Assert.assertNotNull(photos);
        Assert.assertFalse(photos.isEmpty());
        Assert.assertTrue(photos.stream().allMatch(p -> p.getAlbumId() == 1));
    }

    @Test
    @Story("Create photo")
    public void createPhoto() {
        PhotoVORequest request = PhotoVORequestFactory.randomPhotoVORequest();
        photosAPIFacade.postNewPhoto(request)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("schema/photo-schema.json"));
    }
}

