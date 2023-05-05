  package com.sp.controller;

  import com.sp.model.Card;
  import org.springframework.beans.factory.annotation.Value;
  import org.springframework.http.HttpStatus;
  import org.springframework.http.MediaType;
  import org.springframework.http.ResponseEntity;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.*;

  import java.net.URI;
  import java.net.URISyntaxException;
  import java.util.ArrayList;
  import java.util.List;
  
  @Controller // AND NOT @RestController
  public class RequestCrt {

  	@Value("${welcome.message}")
  	private String message;
  
  	private static final String messageLocal="Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
    private static List<AbstractCard> listCard = new ArrayList<AbstractCard>();
  	private static String messageLocal="Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
    private static List<Card> listCard = new ArrayList<Card>();
    static {
        listCard.add(new AbstractCard());
    }

      @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
  	public String index(Model model) {
    
  		model.addAttribute("message", message);
  		model.addAttribute("messageLocal", messageLocal);
  
  		return "index";
  	}
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser(Model model) {

        return "addUser";
    }

  @RequestMapping(value="/addCard", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.OK)
  public void addHero(@RequestBody AbstractCard hero) {
      System.out.println(hero);
      listCard.add(hero);
      System.out.println( "OK AddCard Post " + listCard);
  }

  // /getCard

  @RequestMapping(value="/getCards", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<List<Card>> getCard(){
      System.out.println( "OK GETCard Get" + listCard);
      return ResponseEntity.ok(listCard);
      }
}

