package hestia.msStore.controller;

import hestia.msStore.model.Lista;
import hestia.msStore.payload.ListaResponse;
import hestia.msStore.service.ListaServiceIMPL;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/lista")
public class ListaController {

    private ListaServiceIMPL serviceIMPL;

    @GetMapping
    public ResponseEntity<List<Lista>> findAllListas() {
        return new ResponseEntity<>(serviceIMPL.findAllListas(), HttpStatus.OK);
    }

    @GetMapping("/{listaId}")
    public ResponseEntity<Lista> findListaById(@PathVariable(value = "listaId") int listaId) {
        return new ResponseEntity<>(serviceIMPL.findListaById(listaId), HttpStatus.OK);
    }

    @GetMapping("/comparator/{listaId}")
    public ResponseEntity<List<ListaResponse>> findbyListaComparator(@PathVariable int listaId) {
        return new ResponseEntity<>(serviceIMPL.findbyListaComparator(listaId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lista> createLista(@RequestBody Lista lista) {
        return new ResponseEntity<>(serviceIMPL.createLista(lista), HttpStatus.CREATED);
    }

    @PutMapping("/{listaId}")
    public ResponseEntity<Lista> updateLista(@PathVariable(value = "listaId") int listaId, @RequestBody Lista lista) {
        return new ResponseEntity<>(serviceIMPL.updateLista(listaId, lista), HttpStatus.OK);
    }

    @PutMapping("/add/{listaId}/{productId}")
    public ResponseEntity<Lista> addProductsInLista(@PathVariable int listaId, @PathVariable int productId) {
        var lista = serviceIMPL.addProductsInLista(listaId, productId);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/{listaId}")
    public ResponseEntity<String> deleteListaById(@PathVariable(value = "listaId") int listaId) {
        serviceIMPL.deleteListaById(listaId);
        return new ResponseEntity<>("Lista deleted Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{listaId}/{productId}")
    public ResponseEntity<String> deleteProductInLista(@PathVariable int listaId, @PathVariable int productId) {
        serviceIMPL.deleteProductInLista(listaId, productId);
        return new ResponseEntity<>("Products deleted Successfully", HttpStatus.OK);
    }

}