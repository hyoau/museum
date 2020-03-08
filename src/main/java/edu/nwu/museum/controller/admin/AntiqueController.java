package edu.nwu.museum.controller.admin;

import edu.nwu.museum.common.response.Response;
import edu.nwu.museum.domain.Antique;
import edu.nwu.museum.service.AntiqueService;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AntiqueController {
    @Autowired
    private AntiqueService antiqueService;

    @GetMapping(value = "/api/antique/list")
    public Response getAntiqueList(@RequestParam("offset") Integer offset) {
        ArrayList<Antique> antiques = new ArrayList<>(antiqueService.paginate(offset));
        HashMap<String, Object> data = new HashMap<>();
        for (Antique antique : antiques) {
            data.put("antiques", antiques);
        }
        return new Response(20000, "SUCCESS", data);
    }
}
