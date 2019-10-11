package edu.nwu.museum.controller;

import edu.nwu.museum.common.authentication.Response;
import edu.nwu.museum.domain.Antique;
import edu.nwu.museum.service.AntiqueService;
import java.util.ArrayList;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AntiqueController {
  @Autowired
  private AntiqueService antiqueService;

  @CrossOrigin("*")
  @RequestMapping(value = "/api/antique/list", method = RequestMethod.GET)
  public Response getAntiqueList(@RequestParam("offset") Integer offset) {
    ArrayList<Antique> antiques = new ArrayList<>(antiqueService.paginate(offset));
    HashMap<String, Object> data = new HashMap<>();
    for (Antique antique: antiques) {
      data.put("antiques", antiques);
    }
    return new Response(20000, "SUCCESS", data);
  }
}
