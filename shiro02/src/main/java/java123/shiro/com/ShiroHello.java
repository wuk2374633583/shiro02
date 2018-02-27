package java123.shiro.com;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroHello {
	public static void main(String[] args) {
		
		// ��ȡ�����ļ�����ʼ��SecurityManager����
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
		// ��ȡsecurityManagerʵ��
		SecurityManager securityManager=factory.getInstance();
		// ��securityManagerʵ���󶨵�SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// �õ���ǰִ�е��û�
		Subject currentUser=SecurityUtils.getSubject();
		System.out.println(currentUser.getPrincipal());
		// ����token���ƣ��û���/����
		UsernamePasswordToken token=new UsernamePasswordToken("wukk","123456");
		// �����֤
		try {
			currentUser.login(token);
			System.out.println("�����֤�ɹ�");
			//�õ���ǰ�û�����
			System.out.println(currentUser.getPrincipal());
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			System.out.println("�����֤ʧ��");
			e.printStackTrace();
		}
		// �˳�
		currentUser.logout();
		
		
	}
}
