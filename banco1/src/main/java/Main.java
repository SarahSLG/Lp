import entity.Pessoa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Sarah","Sabongi","sarah@njjd");
        Pessoa p2 = new Pessoa("Bia","Alves","alves@njjd");
        Pessoa p3 = new Pessoa("Kaio","Luiz","luiz@njjd");
        Pessoa p4 = new Pessoa("Wallas","lindo","wa@njjd");
        Pessoa p5 = new Pessoa("Elisa","Teixeira","elisa@njjd");

        Session session = HibernateUtil.getSessionFactory().openSession(); //faz uma conexao usando o obj session: todas aslinhas debaixo sao as transaçoes/mudandaças que estou fazendo

        Transaction transaction = session.beginTransaction(); //pegando minha sessao e iniciando uma transação

        session.persist(p1);
        session.persist(p2);
        session.persist(p3);
        session.persist(p4);
        session.persist(p5);


        transaction.commit(); //da transaçao

       //recebe todos os registros do bbd, recebe uma lista de pessoas
        List<Pessoa> pessoas = session.createQuery("from Pessoa", Pessoa.class).list();

        pessoas.forEach(p -> System.out.println(p.toString())); //quando se tem uma linha pd usar esse jeito: for it diferenciado
        //o p é o mesmo d forEach mas nao é necessario colocar o tipo
        //para cada p da lista pessoa eu executo tal comando


    }
}
