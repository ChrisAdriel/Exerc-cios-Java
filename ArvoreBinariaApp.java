import java.io.*;
import java.util.*;

class No {
    long item;
    No dir, esq;
}

class Tree {
    private No root;

    public Tree() {
        root = null;
    }

    public void inserir(long v) {
        No novo = new No();
        novo.item = v;

        if (root == null) {
            root = novo;
            return;
        }

        No atual = root;
        No pai;
        while (true) {
            pai = atual;
            if (v <= atual.item) {
                atual = atual.esq;
                if (atual == null) {
                    pai.esq = novo;
                    return;
                }
            } else {
                atual = atual.dir;
                if (atual == null) {
                    pai.dir = novo;
                    return;
                }
            }
        }
    }

    public No buscar(long chave) {
        No atual = root;
        while (atual != null && atual.item != chave) {
            atual = (chave < atual.item) ? atual.esq : atual.dir;
        }
        return atual;
    }

    public boolean remover(long v) {
        No atual = root, pai = null;
        boolean filhoEsq = true;

        while (atual != null && atual.item != v) {
            pai = atual;
            if (v < atual.item) {
                atual = atual.esq;
                filhoEsq = true;
            } else {
                atual = atual.dir;
                filhoEsq = false;
            }
        }

        if (atual == null) return false;

        if (atual.esq == null && atual.dir == null) {
            if (atual == root) root = null;
            else if (filhoEsq) pai.esq = null;
            else pai.dir = null;
        } else if (atual.dir == null) {
            if (atual == root) root = atual.esq;
            else if (filhoEsq) pai.esq = atual.esq;
            else pai.dir = atual.esq;
        } else if (atual.esq == null) {
            if (atual == root) root = atual.dir;
            else if (filhoEsq) pai.esq = atual.dir;
            else pai.dir = atual.dir;
        } else {
            No sucessor = noSucessor(atual);
            if (atual == root) root = sucessor;
            else if (filhoEsq) pai.esq = sucessor;
            else pai.dir = sucessor;
            sucessor.esq = atual.esq;
        }

        return true;
    }

    private No noSucessor(No apaga) {
        No paidosucessor = apaga, sucessor = apaga;
        No atual = apaga.dir;

        while (atual != null) {
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.esq;
        }

        if (sucessor != apaga.dir) {
            paidosucessor.esq = sucessor.dir;
            sucessor.dir = apaga.dir;
        }
        return sucessor;
    }

    public void caminhar() {
        System.out.println("Exibindo em ordem: ");
        inOrder(root);
        System.out.println("\nExibindo em pos-ordem: ");
        posOrder(root);
        System.out.println("\nExibindo em pre-ordem: ");
        preOrder(root);
        System.out.println("\nAltura da árvore: " + altura(root));
        System.out.println("Quantidade de folhas: " + folhas(root));
        System.out.println("Quantidade de Nós: " + contarNos(root));
        if (root != null) {
            System.out.println("Valor mínimo: " + min().item);
            System.out.println("Valor máximo: " + max().item);
        }
    }

    private void inOrder(No atual) {
        if (atual != null) {
            inOrder(atual.esq);
            System.out.print(atual.item + " ");
            inOrder(atual.dir);
        }
    }

    private void preOrder(No atual) {
        if (atual != null) {
            System.out.print(atual.item + " ");
            preOrder(atual.esq);
            preOrder(atual.dir);
        }
    }

    private void posOrder(No atual) {
        if (atual != null) {
            posOrder(atual.esq);
            posOrder(atual.dir);
            System.out.print(atual.item + " ");
        }
    }

    private int altura(No atual) {
        if (atual == null) return -1;
        return 1 + Math.max(altura(atual.esq), altura(atual.dir));
    }

    private int folhas(No atual) {
        if (atual == null) return 0;
        if (atual.esq == null && atual.dir == null) return 1;
        return folhas(atual.esq) + folhas(atual.dir);
    }

    private int contarNos(No atual) {
        if (atual == null) return 0;
        return 1 + contarNos(atual.esq) + contarNos(atual.dir);
    }

    private No min() {
        No atual = root;
        while (atual.esq != null) {
            atual = atual.esq;
        }
        return atual;
    }

    private No max() {
        No atual = root;
        while (atual.dir != null) {
            atual = atual.dir;
        }
        return atual;
    }
}

public class ArvoreBinariaApp {
    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        Tree arv = new Tree();
        int opcao;
        long x;
        System.out.println("Programa Árvore Binária de long");
        do {
            System.out.println("\n***********************************");
            System.out.println("Entre com a opção:");
            System.out.println("----1: Inserir");
            System.out.println("----2: Excluir");
            System.out.println("----3: Pesquisar");
            System.out.println("----4: Exibir");
            System.out.println("----5: Sair do programa");
            System.out.println("***********************************");
            System.out.print("-> ");
            opcao = le.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor (long) -> ");
                    x = le.nextLong();
                    arv.inserir(x);
                    break;
                case 2:
                    System.out.print("Informe o valor (long) -> ");
                    x = le.nextLong();
                    if (!arv.remover(x))
                        System.out.println("Valor não encontrado!");
                    break;
                case 3:
                    System.out.print("Informe o valor (long) -> ");
                    x = le.nextLong();
                    if (arv.buscar(x) != null)
                        System.out.println("Valor Encontrado");
                    else
                        System.out.println("Valor não encontrado!");
                    break;
                case 4:
                    arv.caminhar();
                    break;
            }
        } while (opcao != 5);
        le.close();
    }
}
