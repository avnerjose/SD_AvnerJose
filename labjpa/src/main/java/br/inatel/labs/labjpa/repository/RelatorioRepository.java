package br.inatel.labs.labjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.labjpa.entity.NotaCompraItem;

@Repository
public interface RelatorioRepository extends JpaRepository<NotaCompraItem, Long> {

	@Query("""
			SELECT new br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO(
				f.razaoSocial,
				sum(i.quantidade * i.valorCompraProduto)
			)
			FROM NotaCompraItem   i
				join i.notaCompra n
				join n.fornecedor f
			GROUP BY f.razaoSocial
			""")
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor();
}
