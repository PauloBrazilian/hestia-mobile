package hestia.msStore.framework.adapaters.in;

import hestia.msStore.application.service.ListaServiceIMPL;
import hestia.msStore.domain.dto.in.ListaDto;
import hestia.msStore.domain.dto.in.ListaResponse;
import hestia.msStore.domain.dto.in.ProductDto;
import hestia.msStore.domain.model.Product;
import jakarta.annotation.Nullable;
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

    @PostMapping
    public ResponseEntity<ListaDto> createLista(@RequestBody ListaDto listaDto) {
        return new ResponseEntity<>(serviceIMPL.createLista(listaDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ListaDto>> findAllListas() {
        return new ResponseEntity<>(serviceIMPL.findAllListas(), HttpStatus.OK);
    }

    @GetMapping("/{listaId}")
    public ResponseEntity<ListaDto> findListaById(@PathVariable(value = "listaId") Long listaId) {
        return new ResponseEntity<>(serviceIMPL.findListaById(listaId), HttpStatus.OK);
    }

    @GetMapping("/comparator/{listaId}")
    public ResponseEntity<List<ListaResponse>> findbyListaComparator(@PathVariable Long listaId) {
        return new ResponseEntity<>(serviceIMPL.findbyListaComparator(listaId), HttpStatus.OK);
    }

    @PutMapping("/{listaId}")
    public ResponseEntity<ListaDto> updateLista(@PathVariable(value = "listaId") Long listaId, @RequestBody ListaDto listaDto) {
        return new ResponseEntity<>(serviceIMPL.updateLista(listaId, listaDto), HttpStatus.OK);
    }

    @PutMapping("/add/{listaId}/{productId}")
    public ResponseEntity<ListaDto> addProductsInLista(@PathVariable Long listaId, @PathVariable Long productId, @RequestBody ProductDto productDto) {
        var lista = serviceIMPL.addProductsInLista(listaId, productId, productDto);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/{listaId}")
    public ResponseEntity<String> deleteListaById(@PathVariable(value = "listaId") Long listaId) {
        serviceIMPL.deleteListaById(listaId);
        return new ResponseEntity<>("Lista deleted Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{listaId}/{productId}")
    public ResponseEntity<String> deleteProductInLista(@PathVariable Long listaId, @PathVariable Long productId) {
        serviceIMPL.deleteProductInLista(listaId, productId);
        return new ResponseEntity<>("Products deleted Successfully", HttpStatus.OK);
    }

}