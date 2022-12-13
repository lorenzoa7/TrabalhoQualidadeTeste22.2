package Funcionais.Equivalencia;

import aplicacao.Produto;
import java.util.ArrayList;
import model.ProdutoDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


//testes1

// TestaVenda, por determinar uma condição lógica, faremos um teste válido ou inválido
public class TestaProduto {
    
    public TestaProduto() {
    }
    
    // Teste para verificar se o produto está disponível para venda caso a quantidade disponível no estoque seja acima de zero e se está liberado pra venda
    // Teste válido
    @Test
    public void qtdDisponivelValido() {
        Produto produto = new Produto();
        ProdutoDAO produtodao = new ProdutoDAO();
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        boolean validarDisponivel = false;
        
        produto.setId(0);
        produto.setNome("teste99");
        produto.setDescricao("descricao_teste");
        produto.setPrecoCompra(20.0);
        produto.setPrecoVenda(30.0);
        produto.setQtdDisponivel(5);
        produto.setLiberadoVenda("S");
        produto.setId_categoria(1);
        produtodao.gravar(produto);
        
        listaProdutos = produtodao.getListaDisponiveis();
        for (int i = 0; i < listaProdutos.size(); i++) {
            if ("teste99".equals(listaProdutos.get(i).getNome())) {
                validarDisponivel = true;
                break;
            }
        }
        
        produtodao.excluirUltimo();
        assertTrue(validarDisponivel);
    }
    
    // Teste para verificar se o produto está indisponível para venda caso a quantidade disponível no estoque seja zero
    // Teste inválido
    @Test
    public void qtdDisponivelInvalido() {
        Produto produto = new Produto();
        ProdutoDAO produtodao = new ProdutoDAO();
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        boolean validarDisponivel = false;
        
        produto.setId(0);
        produto.setNome("teste98");
        produto.setDescricao("descricao_teste");
        produto.setPrecoCompra(20.0);
        produto.setPrecoVenda(30.0);
        produto.setQtdDisponivel(0);
        produto.setLiberadoVenda("S");
        produto.setId_categoria(1);
        produtodao.gravar(produto);
        
        listaProdutos = produtodao.getListaDisponiveis();
        for (int i = 0; i < listaProdutos.size(); i++) {
            if ("teste98".equals(listaProdutos.get(i).getNome())) {
                validarDisponivel = true;
                break;
            }
        }
        
        produtodao.excluirUltimo();
        assertTrue(validarDisponivel);
    }
    
    // Teste para verificar se o produto está indisponível para venda caso o mesmo não esteja liberado para venda
    // Teste inválido
    @Test
    public void liberadoVendaValido() {
        Produto produto = new Produto();
        ProdutoDAO produtodao = new ProdutoDAO();
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        boolean validarDisponivel = false;
        
        produto.setId(0);
        produto.setNome("teste97");
        produto.setDescricao("descricao_teste");
        produto.setPrecoCompra(20.0);
        produto.setPrecoVenda(30.0);
        produto.setQtdDisponivel(5);
        produto.setLiberadoVenda("N");
        produto.setId_categoria(1);
        produtodao.gravar(produto);
        
        listaProdutos = produtodao.getListaDisponiveis();
        for (int i = 0; i < listaProdutos.size(); i++) {
            if ("teste97".equals(listaProdutos.get(i).getNome())) {
                validarDisponivel = true;
                break;
            }
        }
        
        produtodao.excluirUltimo();
        assertTrue(validarDisponivel);
    }
}
