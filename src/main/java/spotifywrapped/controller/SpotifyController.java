package spotifywrapped.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spotifywrapped.model.TestModel;
import spotifywrapped.service.SpotifyService;


@RestController
public class SpotifyController {
    @Autowired private SpotifyService spotifyService;

    @GetMapping("/")
    public ResponseEntity<TestModel> index(@RequestParam(name = "id") Integer id) throws Exception {
        return new ResponseEntity<>(spotifyService.getData(id), HttpStatus.OK);
    }
}
