using backend.Data;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;
using backend.Repository.PaisRepository;
using backend.Services.PaisServices;
using backend.Repository.EstadoRepository;
using backend.Services.EstadoServices;
using backend.Services.OrcamentoPedidoServices;
using backend.Repositories.OrcamentoPedidoRepositories;
using backend.Services.OrcamentoPedidoProdutoServices;
using backend.Repositories.OrcamentoPedidoProdutoRepositories;

var builder = WebApplication.CreateBuilder(args);

// Configuração do DbContext
builder.Services.AddDbContext<ApplicationDbContext>(options =>
{
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection"));
    options.EnableSensitiveDataLogging(false); //Para mostrar no erro a tabela,campo,etc do banco de dados
});



builder.Services.AddCors(options => {
    options.AddPolicy("AllowAllOrigins", builder => {
        builder.AllowAnyOrigin();
        builder.AllowAnyMethod();
        builder.AllowAnyHeader();
    });
});

// Adicionando os serviços de repositório e serviço

builder.Services.AddScoped<PaisRepository>();
builder.Services.AddScoped<PaisService>();

builder.Services.AddScoped<EstadoRepository>();
builder.Services.AddScoped<EstadoService>();

builder.Services.AddScoped<OrcamentoPedidoRepository>();
builder.Services.AddScoped<OrcamentoPedidoService>();

builder.Services.AddScoped<OrcamentoPedidoProdutoRepository>();
builder.Services.AddScoped<OrcamentoPedidoProdutoService>();



// Adicionando o controlador
builder.Services.AddControllers();

var app = builder.Build();

app.UseCors("AllowAllOrigins");
// Configuração do middleware
app.UseRouting();
app.UseEndpoints(endpoints =>
{
    endpoints.MapControllers();
});

app.Run();
