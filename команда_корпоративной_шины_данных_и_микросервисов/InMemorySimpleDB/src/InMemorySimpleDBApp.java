import domain.Credential;
import domain.MemoryDBCRUDImp;

import java.util.Scanner;

public class InMemorySimpleDBApp {
    public static void main(String[] args) {
        MemoryDBCRUDImp memoryDBCRUDImp = new MemoryDBCRUDImp();
        Scanner scanner = new Scanner(System.in);
        boolean cycleCondition = true;
        while (cycleCondition) {
            try {
                System.out.println("1. �������� ����� ������\n2. ������� ������\n" +
                        "3. �������� ������\n4. �������� ��� ������");
                int switchCondition = scanner.nextInt();
                switch (switchCondition) {
                    case 1 -> {
                        long account = scanner.nextLong();
                        String name = scanner.next();
                        double value = scanner.nextDouble();
                        String sout = memoryDBCRUDImp.postEntity(new Credential(account, name, value));
                        System.out.println(sout);
                    }
                    case 2 -> {
                        long account = scanner.nextLong();
                        String sout = memoryDBCRUDImp.deleteEntity(account);
                        System.out.println(sout);

                    }
                    case 3 -> {
                        long account = scanner.nextLong();
                        String sout = memoryDBCRUDImp.getEntity(account);
                        System.out.println(sout);
                    }
                    case 4 -> {
                        memoryDBCRUDImp.getAllEntity();
                    }
                    case 0 -> {
                        cycleCondition = false;
                    }
                    default -> {
                        System.out.println("��� ��� �� �������� �� ���");
                    }
                }
            } catch (Exception e) {
                System.out.println("������");
            }
        }
    }
}
