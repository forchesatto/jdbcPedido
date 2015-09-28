package relatorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import conexao.ConexaoUtil;
import dao.factory.DaoFactory;
import model.Produto;

public class RelatorioTeste {

	public static void main(String[] args) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigo", 1);
		
//		new RelatorioUtil().viewReport(
//				"src/relatorio/PrimeiroRelatorio.jasper",
//				ConexaoUtil.getCon(), parametros);
//
//		new RelatorioUtil().gerarPdf(
//				"src/relatorio/PrimeiroRelatorio.jasper",
//				ConexaoUtil.getCon(), parametros);

		List<Produto> produtos = DaoFactory.get().produtoDao().todos();
				
		new RelatorioUtil().compileViewReport(
				"src/relatorio/PrimeiroRelatorioList.jrxml",
				produtos, parametros);
	}
}
