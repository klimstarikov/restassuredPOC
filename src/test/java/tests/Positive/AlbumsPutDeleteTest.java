package tests.Positive;

import facade.AlbumsAPIFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Album.AlbumVO;
import model.Album.AlbumVOBuilder;
import model.Album.AlbumVORequest;
import model.Album.AlbumVORequestFactory;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

@Epic("Album API Tests")
@Feature("Album Put/Delete Feature")
public class AlbumsPutDeleteTest extends BaseTest {
    private final AlbumsAPIFacade albumsAPIFacade = new AlbumsAPIFacade();

    @Test
    @Story("Update album by id")
    public void updateAlbumById() {
        AlbumVORequest request = AlbumVORequestFactory.randomAlbumVORequest();
        AlbumVO actual = albumsAPIFacade.postNewAlbum(request)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .as(AlbumVO.class);

        AlbumVO expected = new AlbumVOBuilder()
                .withId(actual.getId())
                .withUserId(request.getUserId())
                .withTitle(request.getTitle())
                .withBody(request.getBody())
                .build();

        Assert.assertEquals(actual, expected);
    }

    @Test
    @Story("Delete album by id")
    public void deleteAlbumById() {
        albumsAPIFacade.deleteAlbumById(1)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
