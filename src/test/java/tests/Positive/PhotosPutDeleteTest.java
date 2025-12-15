package tests.Positive;

import facade.PhotosAPIFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Photo.PhotoVO;
import model.Photo.PhotoVOBuilder;
import model.Photo.PhotoVORequest;
import model.Photo.PhotoVORequestFactory;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

@Epic("Photo API Tests")
@Feature("Photo Put/Delete Feature")
public class PhotosPutDeleteTest extends BaseTest {
    private final PhotosAPIFacade photosAPIFacade = new PhotosAPIFacade();

    @Test
    @Story("Update photo by id")
    public void updatePhotoById() {
        PhotoVORequest request = PhotoVORequestFactory.randomPhotoVORequest();
        Response postResp = photosAPIFacade.postNewPhoto(request)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();

        int createdId = postResp.jsonPath().getInt("id");
        PhotoVO actual = postResp.as(PhotoVO.class);

        PhotoVO expected = new PhotoVOBuilder()
                .withId(createdId)
                .withAlbumId(request.getAlbumId())
                .withTitle(request.getTitle())
                .withUrl(request.getUrl())
                .withThumbnailUrl(request.getThumbnailUrl())
                .withBody(request.getBody())
                .build();

        Assert.assertEquals(actual, expected);
    }

    @Test
    @Story("Delete photo by id")
    public void deletePhotoById() {
        photosAPIFacade.deletePhotoById(1)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
