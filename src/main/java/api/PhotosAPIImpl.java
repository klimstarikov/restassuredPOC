package api;

import io.restassured.response.Response;
import model.Photo.PhotoVORequest;

import static io.restassured.RestAssured.given;
import static utils.SpecFactory.requestSpec;

public class PhotosAPIImpl {
    public Response getPhotoById(int id) {
        return given()
                .spec(requestSpec())
                .pathParam("id", id)
                .when()
                .get("/photos/{id}");
    }

    public Response getAllPhotos() {
        return given()
                .spec(requestSpec())
                .when()
                .get("/photos");
    }

    public Response getPhotosByAlbumId(int albumId) {
        return given()
                .spec(requestSpec())
                .queryParam("albumId", albumId)
                .when()
                .get("/photos");
    }

    public Response getPhotosByAlbumPath(int albumId) {
        return given()
                .spec(requestSpec())
                .pathParam("albumId", albumId)
                .when()
                .get("/albums/{albumId}/photos");
    }

    public Response postNewPhoto(PhotoVORequest body) {
        return given()
                .spec(requestSpec())
                .body(body)
                .when()
                .post("/photos");
    }

    public Response updatePhotoById(int photoId, PhotoVORequest body) {
        return given()
                .spec(requestSpec())
                .pathParam("photoId", photoId)
                .body(body)
                .when()
                .put("/photos/{photoId}");
    }

    public Response deletePhotoById(int photoId) {
        return given()
                .spec(requestSpec())
                .pathParam("photoId", photoId)
                .when()
                .delete("/photos/{photoId}");
    }
}

