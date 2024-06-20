package hestia.msStore.controller;

import hestia.msStore.payload.ListaDto;
import hestia.msStore.payload.ListaResponse;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.service.ListaServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista")
public class ListaController {

    @Autowired
    private ListaServiceIMPL serviceIMPL;


    @GetMapping
    public ResponseEntity<List<ListaDto>> findAllListas() {
        return new ResponseEntity<>(serviceIMPL.findAllListas(), HttpStatus.OK);
    }

    @GetMapping("/{listaId}")
    public ResponseEntity<List<ListaDto>> findAllListaById(@PathVariable(value = "listaId") int listaId) {
        return new ResponseEntity<>(serviceIMPL.findAllListaById(listaId), HttpStatus.OK);
    }

    @GetMapping("/comparator/{listaId}")
    public ResponseEntity<List<ListaResponse>> findbyListaComparator(@PathVariable int listaId){
        return new ResponseEntity<>(serviceIMPL.findbyListaComparator(listaId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ListaDto> createLista(@RequestBody ListaDto listaDto){
        return new ResponseEntity<>(serviceIMPL.createLista(listaDto), HttpStatus.CREATED);
    }

    @PutMapping("/{listaId}")
    public ResponseEntity<ListaDto> updateLista(@PathVariable(value = "listaId") int listaId, @RequestBody ListaDto listaDto){
        return new ResponseEntity<>(serviceIMPL.updateLista(listaId, listaDto), HttpStatus.OK);
    }

    @PutMapping("/add/{listaId}/{productId}")
    public ResponseEntity<ListaDto> addProductsInLista(@PathVariable int listaId, @PathVariable int productId){
        var listaDto = serviceIMPL.addProductsInLista(listaId, productId);
        return new ResponseEntity<>(listaDto, HttpStatus.OK);
    }

    @DeleteMapping("/{listaId}")
    public ResponseEntity<String> deleteListaById(@PathVariable(value = "listaId") int listaId){
        serviceIMPL.deleteListaById(listaId);
        return new ResponseEntity<>("Lista deleted Successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{listaId}/{productId}")
    public ResponseEntity<String> deleteProductInLista(@PathVariable int listaId, @PathVariable int productId){
        serviceIMPL.deleteProductInLista(listaId, productId);
        return new ResponseEntity<>("Products deleted Successfully",HttpStatus.OK);
    }

}