package com.premolexpert.api.example;

/**
 * EXEMPLO DE USO DA ANOTAÇÃO @RequiresPermission NOS CONTROLLERS
 *
 * Copie e adapte para seus controllers reais
 */

// ============================================
// EXEMPLO 1: Controller de Clientes
// ============================================

// @RestController
// @RequestMapping("/clientes")
// public class ClienteController {
//
//     @GetMapping
//     @RequiresPermission(telaNom = "Clientes", acaoNom = "Consultar")
//     public ResponseEntity<?> getAllClientes(@RequestParam int page, @RequestParam int size) {
//         // Apenas usuários com permissão "Clientes - Consultar" podem acessar
//         return ResponseEntity.ok("Listando clientes...");
//     }
//
//     @GetMapping("/{id}")
//     @RequiresPermission(telaNom = "Clientes", acaoNom = "Consultar")
//     public ResponseEntity<?> getClienteById(@PathVariable Integer id) {
//         // Apenas usuários com permissão "Clientes - Consultar" podem acessar
//         return ResponseEntity.ok("Detalhes do cliente " + id);
//     }
//
//     @PostMapping
//     @RequiresPermission(telaNom = "Clientes", acaoNom = "Criar")
//     public ResponseEntity<?> createCliente(@RequestBody ClienteDTO clienteDTO) {
//         // Apenas usuários com permissão "Clientes - Criar" podem acessar
//         return ResponseEntity.status(201).body("Cliente criado com sucesso");
//     }
//
//     @PutMapping("/{id}")
//     @RequiresPermission(telaNom = "Clientes", acaoNom = "Editar")
//     public ResponseEntity<?> updateCliente(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
//         // Apenas usuários com permissão "Clientes - Editar" podem acessar
//         return ResponseEntity.ok("Cliente atualizado com sucesso");
//     }
//
//     @DeleteMapping("/{id}")
//     @RequiresPermission(telaNom = "Clientes", acaoNom = "Deletar")
//     public ResponseEntity<?> deleteCliente(@PathVariable Integer id) {
//         // Apenas usuários com permissão "Clientes - Deletar" podem acessar
//         return ResponseEntity.ok("Cliente deletado com sucesso");
//     }
// }

// ============================================
// EXEMPLO 2: Controller de Orçamentos
// ============================================

// @RestController
// @RequestMapping("/orcamentos")
// public class OrcamentoPedidoController {
//
//     @GetMapping
//     @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Consultar")
//     public ResponseEntity<?> getAllOrcamentos(@RequestParam int page, @RequestParam int size) {
//         return ResponseEntity.ok("Listando orçamentos...");
//     }
//
//     @PostMapping
//     @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Criar")
//     public ResponseEntity<?> createOrcamento(@RequestBody OrcamentoPedidoDTO orcDTO) {
//         return ResponseEntity.status(201).body("Orçamento criado com sucesso");
//     }
//
//     @PutMapping("/{id}")
//     @RequiresPermission(telaNom = "Orçamentos", acaoNom = "Editar")
//     public ResponseEntity<?> updateOrcamento(@PathVariable Integer id, @RequestBody OrcamentoPedidoDTO orcDTO) {
//         return ResponseEntity.ok("Orçamento atualizado com sucesso");
//     }
// }

// ============================================
// FLUXO DE FUNCIONAMENTO
// ============================================
//
// 1. Usuário faz login em POST /auth/login
// 2. Sistema retorna JWT token
// 3. Cliente inclui token no header: Authorization: Bearer <token>
// 4. SecurityFilter valida o token e carrega o usuário
// 5. Quando usuário tenta acessar endpoint com @RequiresPermission:
//    - PermissionAspect intercepta a requisição
//    - Obtém o usuário autenticado do SecurityContextHolder
//    - Busca as permissões do perfil no banco de dados
//    - Se tem permissão → permite prosseguir
//    - Se NÃO tem permissão → lança SecurityException (403 Forbidden)
//
// ============================================
// CONFIGURAÇÃO DAS PERMISSÕES NO BANCO
// ============================================
//
// Você precisa inserir as permissões na tabela tbpermissaoacesso:
//
// INSERT INTO tbpermissaoacesso (perid, telid, acaid, usuid, permacesta, permaceincpor, permaceincem)
// VALUES
//   (1, 1, 1, NULL, 1, 1, NOW()),  -- Perfil Admin: Tela Clientes, Ação Consultar
//   (1, 1, 2, NULL, 1, 1, NOW()),  -- Perfil Admin: Tela Clientes, Ação Criar
//   (2, 1, 1, NULL, 1, 1, NOW()),  -- Perfil Vendedor: Tela Clientes, Ação Consultar
//   (2, 2, 1, NULL, 1, 1, NOW());  -- Perfil Vendedor: Tela Orçamentos, Ação Consultar
//
// ============================================

public class ExemploUsoRequiresPermission {
}

