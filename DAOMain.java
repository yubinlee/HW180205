import java.text.SimpleDateFormat;
import java.util.*;

import bigdata.board.dao.MemDAO;
import bigdata.board.dao.PostDAO;
import bigdata.board.vo.MemVO;
import bigdata.board.vo.PostVO;

public class DAOMain {
	public static void main(String[] args) {
		/*
		PostDAO dao = new PostDAO();
		PostVO vo = new PostVO(7, "�ȳ�", "��������", new Date(), "yubin");
		
		if (dao.insertPost(vo)) {
			System.out.println("����");
		}
		
		ArrayList<PostVO> list = dao.selectPost();
		System.out.println("==============================");
		System.out.println("�۹�ȣ	����	�ۼ���	�ۼ���");
		System.out.println("==============================");
		Iterator<PostVO> i = list.iterator();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		while (i.hasNext()) {
			PostVO post = i.next();
			System.out.println(post.getPostno()+"	"+post.getTitle()+"	"+sdf.format(post.getRegdate())+" "+post.getMemid());
		}
		System.out.println("==============================");
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		System.out.print("������ �Խù��� ��ȣ: ");
		int num = scan.nextInt();	
		dao.deletePost(num);
		
		System.out.print("������ �Խù��� ��ȣ: ");
		int num = scan.nextInt();
		System.out.print("����: ");
		String title = scan2.nextLine();
		System.out.print("����: ");
		String content = scan2.nextLine();
		PostVO vo = new PostVO();
		vo.setPostno(num);
		vo.setTitle(title);
		vo.setContent(content);	
		dao.updatePost(vo);
		*/
		
		MemDAO mdao = new MemDAO();
		/*
		MemVO mvo = new MemVO("lee", "1026");
		
		if (mdao.insertMem(mvo)) {
			System.out.println("����");
		}
		*/
		
		Scanner scan2 = new Scanner(System.in);
		/*
		System.out.print("������ ȸ���� ���̵�: ");
		String str = scan2.nextLine();	
		mdao.deleteMem(str);
		*/
		/*
		System.out.print("��й�ȣ �ٲ� ȸ���� ���̵�: ");
		String str = scan2.nextLine();
		MemVO mvo = new MemVO();
		mvo.setMemid(str);
		System.out.print("������ ��й�ȣ: ");
		str = scan2.nextLine();
		mvo.setMempw(str);
		mdao.updateMem(mvo);
		*/
		/*
		System.out.print("��ȸ�� ȸ���� ���̵�: ");
		String str = scan2.nextLine();
		MemVO mvo2 = mdao.selectMem(str);
		System.out.println(mvo2.getMemid()+"	"+mvo2.getMempw());
		*/
		System.out.print("���̵�: ");
		String id = scan2.nextLine();
		System.out.print("��й�ȣ: ");
		String pw = scan2.nextLine();
		MemVO mvo2 = new MemVO(id, pw);
		if (mdao.loginMem(mvo2)) {
			System.out.println("����");
		}
		
	}
}
