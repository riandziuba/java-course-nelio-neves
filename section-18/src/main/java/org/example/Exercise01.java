package org.example;

import org.example.entities.Contract;
import org.example.services.ContractServices;
import org.example.services.PayPalServices;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contract contract = new Contract();
        ContractServices contractServices = new ContractServices(new PayPalServices());

        System.out.println("Entre com os dados do contrato");
        System.out.print("Número:");
        contract.setNumber(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Data (dd/MM/yyyy):");
        contract.setDate(scanner.nextLine());

        System.out.print("Valor do contrato:");
        contract.setValue(scanner.nextDouble());

        System.out.print("Entre com o número de parcelas:");
        int instalmentsNumber = scanner.nextInt();

        contractServices.processContract(contract, instalmentsNumber);

        contract.instalmentsSummary();
    }
}
