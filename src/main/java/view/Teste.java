package view;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Posto;
import model.Usuario;
import model.implementacoes.UsuarioHibernate;

public class Teste {

    public static void main(String args[]) {
        
//        Usuario u = new Usuario("Lulu", "079769", "@", "875568", "lulu", "****");

//        Posto p = PostoController.getInstance().recuperar(2);
//
//        Usuario u = UsuarioController.getInstance().recuperar(1);
//        
//        UsuarioController.getInstance().deletar(u);

//        Cupom cupom = new Cupom(10, 20, u, p);
//        
//        CupomController.getInstance().criar(cupom);
        
//        Cliente c = new Cliente("Tião", "734538", "@", "tiao", "****", null);
//        
//        ClienteController.getInstance().criar(c);
        
//        Cliente c = ClienteController.getInstance().recuperar(1);
//        
//        Posto posto = new Posto("c1", "TiãoPosto", "Shell", 2.1, 2.95, null, c);
//        
//        PostoController.getInstance().criar(posto);

//        Posto posto = PostoController.getInstance().recuperar(2);
//
//        Frentista f = new Frentista("new", 10, posto);
//        
//        FrentistaController.getInstance().criar(f);
        
//        PostoHibernate ph = new PostoHibernate();
       
//        //  CRIAR CLIENTE  //                 
         Usuario usuario = new Usuario("nome", "cpf", "email", "numCelular", "login", "senha");
        
        UsuarioHibernate.getinstanceUsuario().criar(usuario);
        
        //  ALTERAR CLIENTE  //
//        Cliente c;
//        c = ch.recuperar(4);
//        c.setNome("Joao");
//        ch.alterar(c);
        // DELETAR CLIENTE  //
//        Cliente c;3,
//        c = ch.recuperar(3);
//        ch.deletar(c);

//        //  CRIAR USUARIO  //
//        Usuario usuario = new Usuario("Pedro Paulo", "025.554.487-04", "pedro_paulo_vitor@naotenhoemail.com", "999-1524", "p_paulo", "*******");
//        uh.criar(usuario);
//        //  ALTERAR USUARIO  //
//        Usuario u;
//        u = uh.recuperar(2);
//        u.setNome("Joao Pedro");
//        uh.alterar(u);
//        //  DELETAR USUARIO  //
//        Usuario u;
//        u = uh.recuperar(2);
//        uh.deletar(u);
//        //  CRIAR POSTO  //
//        Posto posto = new Posto("Av. Castanho Oliveira", "DisLub", "Shell", 3.5, 2.5, null,ch.recuperar(1));
//        ph.criar(posto);
        //  ALTERAR POSTO  //
//        Usuario u;
//        u = uh.recuperar(2);
//        u.setNome("Joao Pedro");
//        uh.alterar(u);
//        //  DELETAR POSTO  //
//        Usuario u;
//        u = uh.recuperar(2);
//        uh.deletar(u);
//        PostoHibernate ph = new PostoHibernate();
//    
//    private String endereco;
//    @Column(nullable = false,length = 25)
//    private String nome;
//    @Column(nullable = false, length =25)
//    private String distribuidora;
//    @Column(nullable = false)
//    private double precoGasolina;
//    @Column(nullable = false)
//    private double precoAlcool;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "frentista", fetch = FetchType.EAGER)
//    private List<Frentista> frentistas;
//        FrentistaHibernate fh = new FrentistaHibernate();
//        List<Frentista> list = fh.recuperarTodos();
//
//        Posto posto = new Posto("C2", "Sebas posto", "Shell", 2.15, 1.10, null, null);
//
//        ph.criar(posto);
//        Cliente c = new Cliente("Titi", "6786867", "teste", "titi", "***" , null);
//
//        ClienteController.getInstance().criar(c);

    }
}
