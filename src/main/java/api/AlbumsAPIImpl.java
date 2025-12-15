package api;

import io.restassured.response.Response;
import model.Album.AlbumVORequest;

import static io.restassured.RestAssured.given;
import static utils.SpecFactory.requestSpec;

public class AlbumsAPIImpl {
    public Response getAlbumById(int id) {
        return given()
                .spec(requestSpec())
                .pathParam("id", id)
                .when()
                .get("/albums/{id}");
    }

    public Response getAllAlbums() {
        return given()
                .spec(requestSpec())
                .when()
                .get("/albums");
    }

    public Response getAlbumsByUserId(int userId) {
        return given()
                .spec(requestSpec())
                .queryParam("userId", userId)
                .when()
                .get("/albums");
    }

    public Response postNewAlbum(AlbumVORequest body) {
        return given()
                .spec(requestSpec())
                .body(body)
                .when()
                .post("/albums");
    }

    public Response updateAlbumById(int albumId, AlbumVORequest body) {
        return given()
                .spec(requestSpec())
                .pathParam("albumId", albumId)
                .body(body)
                .when()
                .put("/albums/{albumId}");
    }

    public Response deleteAlbumById(int albumId) {
        return given()
                .spec(requestSpec())
                .pathParam("albumId", albumId)
                .when()
                .delete("/albums/{albumId}");
    }
}
