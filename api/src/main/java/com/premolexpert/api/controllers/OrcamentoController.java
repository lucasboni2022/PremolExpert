package com.premolexpert.api.controllers;

import com.premolexpert.api.models.OrcamentoModel;
import com.premolexpert.api.services.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamento")

public class OrcamentoController {

    @Autowired
    private OrcamentoService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<OrcamentoModel> getAll() {
        return service.getAllOrcamentos();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoModel> getById(@PathVariable Integer id) {
        return service.getOrcamentoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<OrcamentoModel> salvar(@RequestBody OrcamentoModel orcamento) {
        OrcamentoModel orcamentoSalvo = service.saveOrcamento(orcamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoSalvo);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoModel> atualizar(@PathVariable Integer id, @RequestBody OrcamentoModel orcamento) {
        OrcamentoModel orcamentoSalvo = service.updateOrcamento(id, orcamento);
        return ResponseEntity.status(HttpStatus.OK).body(orcamentoSalvo);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.deleteOrcamento(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/proximo-numero-processo-emp/{empId}")
    public ResponseEntity<Integer> getProximoOrcNumProEmp(@PathVariable Integer empId) {
        Integer ultimoNumProEmp = service.getProximoOrcNumProEmp(empId);
        return ResponseEntity.ok(ultimoNumProEmp);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualiza-etapa-processo-emp/{orcId}/{orcEtap}")
    public ResponseEntity<String> atualizarEtapaProcessoEmpresa(@PathVariable Integer orcId,@PathVariable Integer orcEtap) {
        try {
            service.atualizarEtapaProcessoEmpresa(orcId,orcEtap);
            return ResponseEntity.ok("ok");
        } catch (RuntimeException e) {
            // Se uma RuntimeException for lançada, retorna erro 404 ou 500 com a mensagem
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    /* assim não pega erro da service...
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualiza-etapa-processo-emp/{orcId}")
    public ResponseEntity<Integer> atualizarEtapaProcessoEmpresa(@PathVariable Integer orcId) {
        service.atualizarEtapaProcessoEmpresa(orcId);
        return ResponseEntity.ok(orcId);
    }
    */

}
