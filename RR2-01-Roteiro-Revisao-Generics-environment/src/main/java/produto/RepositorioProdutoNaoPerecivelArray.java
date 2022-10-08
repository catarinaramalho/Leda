package produto;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutoNaoPerecivelArray extends
		RepositorioProdutosArray<ProdutoNaoPerecivel> {

	public RepositorioProdutoNaoPerecivelArray(int size) {
		super(size);
	}

	@Override
	public void inserir(ProdutoNaoPerecivel produto) {
		if (produto instanceof ProdutoNaoPerecivel) {
			super.inserir(produto);
		}
	}

	@Override
	public void atualizar(ProdutoNaoPerecivel produto) {
		if (produto instanceof ProdutoNaoPerecivel) {
			super.atualizar(produto);
		}
	}

}
