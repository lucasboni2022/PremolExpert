using backend.Model.PaisModel;
using backend.Models.EstadoModels;
using backend.Models.OrcamentoPedidoModels;
using backend.Models.OrcamentoPedidoProdutoModels;
using backend.Models.OrcamentoPedidoProdutoFabModels;
using backend.Models.OrcamentoPedidoProdutoFabProModels;
using Microsoft.EntityFrameworkCore;

namespace backend.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options) { }

        public DbSet<PaisModel> TBPais { get; set; }
        public DbSet<EstadoModel> TBEstado { get; set; }
        public DbSet<OrcamentoPedidoModel> TBOrcamentoPedido { get; set; }
        public DbSet<OrcamentoPedidoProdutoModel> TBOrcamentoPedidoProduto { get; set; }
        public DbSet<OrcamentoPedidoProdutoFabModel> TBOrcamentoPedidoProdutoFab { get; set; }
        public DbSet<OrcamentoPedidoProdutoFabProModel> TBOrcamentoPedidoProdutoFabPro { get; set; }
        
    }
}

