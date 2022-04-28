package com.portaljmti.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.portaljmti.curso.entidades.Categoria;
import com.portaljmti.curso.entidades.ItemPedido;
import com.portaljmti.curso.entidades.Pagamento;
import com.portaljmti.curso.entidades.Pedido;
import com.portaljmti.curso.entidades.Produto;
import com.portaljmti.curso.entidades.Usuario;
import com.portaljmti.curso.entidades.enums.StatusPedido;
import com.portaljmti.curso.repositorios.RepositorioCategoria;
import com.portaljmti.curso.repositorios.RepositorioItemPedido;
import com.portaljmti.curso.repositorios.RepositorioPedido;
import com.portaljmti.curso.repositorios.RepositorioProduto;
import com.portaljmti.curso.repositorios.RepositorioUsuario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	private RepositorioPedido repositorioPedido;

	@Autowired
	private RepositorioCategoria repositorioCategoria;

	@Autowired
	private RepositorioProduto repositorioProduto;

	@Autowired
	private RepositorioItemPedido repositorioItemPedido;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");

		Produto p1 = new Produto(null, "O Senhor dos Aneis", "As duas Torres.", 90.5, "");
		Produto p2 = new Produto(null, "Full HD Samsung T5300", "HDR, Sistema Operacional Tizen, Wi-Fi, Espelhamento de Tela, Dolby Digital Plus, HDMI e USB.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Air 13", "Apple M1 (8GB 256GB SSD) Cinza Espacial.", 8400.0, "");
		Produto p4 = new Produto(null, "Notebook Gamer Dell G15", "10ª geração de Intel® Core™ i5-10500H (6-core, cache de 12MB, até 4.5GHz).", 6100.0, "");
		Produto p5 = new Produto(null, "O Hobbit: Versão Ilustrada", "Ou Lá e Volta Novamente.", 206.99, "");

		repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
		repositorioProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);

		repositorioProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Usuario u1 = new Usuario(null, "Mike Ehrmantraut", "mikeer@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Jimmy McGill", "jimmym@gmail.com", "977777777", "123456");

		Pedido o1 = new Pedido(null, Instant.parse("2022-07-20T19:53:07Z"), StatusPedido.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2022-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2022-07-22T15:21:22Z"), StatusPedido.PAGO, u1);

		repositorioUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioPedido.saveAll(Arrays.asList(o1, o2, o3));

		ItemPedido oi1 = new ItemPedido(o1, p1, 2, p1.getPreço());
		ItemPedido oi2 = new ItemPedido(o1, p3, 1, p3.getPreço());
		ItemPedido oi3 = new ItemPedido(o2, p3, 2, p3.getPreço());
		ItemPedido oi4 = new ItemPedido(o3, p5, 2, p5.getPreço());

		repositorioItemPedido.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2022-07-20T21:53:07Z"), o1);
		o1.setPagamento(pag1);
		
		repositorioPedido.save(o1);
	}
}