package Ex6_ArvoreB;

public class ArvoreB {
    private Pagina root;

    public ArvoreB() {
        root = new Pagina(true); // A raiz é inicialmente uma folha
    }

    // Função para inserir uma chave na árvore B
    public void inserir(int chave) {
        Pagina raiz = root;
        if (raiz.tamanho == 4) {
            Pagina pagina = new Pagina(false);
            root = pagina;
            pagina.filhos[0] = raiz;
            dividirFilhos(pagina, 0);
            inserirEmPaginaComEspaco(pagina, chave);
        } else {
            inserirEmPaginaComEspaco(raiz, chave);
        }
    }

    // Função para inserir em um nó que não está cheio
    private void inserirEmPaginaComEspaco(Pagina pagina, int chave) {
        int i = pagina.tamanho - 1;
        if (pagina.isFolha) {
            while (i >= 0 && chave < pagina.chaves[i]) {
                pagina.chaves[i + 1] = pagina.chaves[i];
                i--;
            }
            pagina.chaves[i + 1] = chave;
            pagina.tamanho++;
        } else {
            while (i >= 0 && chave < pagina.chaves[i]) {
                i--;
            }
            i++;
            if (pagina.filhos[i].tamanho == 3) {
                dividirFilhos(pagina, i);
                if (chave > pagina.chaves[i]) {
                    i++;
                }
            }
            inserirEmPaginaComEspaco(pagina.filhos[i], chave);
        }
    }

    // Função para dividir um nó filho quando está cheio
    private void dividirFilhos(Pagina pai, int i) {
        Pagina filhoDireita = new Pagina(pai.filhos[i].isFolha);
        Pagina filhoEsquerda = pai.filhos[i];
        pai.filhos[i] = filhoEsquerda;
        pai.filhos[i + 1] = filhoDireita;

        for (int j = 3; j > i; j--) {
            pai.filhos[j] = pai.filhos[j - 1];
            pai.chaves[j] = pai.chaves[j - 1];
        }
        pai.chaves[i] = filhoEsquerda.chaves[2];
        pai.tamanho++;

        filhoDireita.tamanho = 1;
        filhoDireita.chaves[0] = filhoEsquerda.chaves[3];

        if (!filhoEsquerda.isFolha) {
            filhoDireita.filhos[1] = filhoEsquerda.filhos[4];
            filhoDireita.filhos[0] = filhoEsquerda.filhos[3];
        }
        filhoEsquerda.chaves[3] = 0;
        filhoEsquerda.chaves[2] = 0;
        filhoEsquerda.tamanho = 2;
    }

    // Função para imprimir a árvore B em ordem
    public void imprimirNaOrdem() {
        imprimirNaOrdem(root);
    }

    private void imprimirNaOrdem(Pagina pagina) {
        if (pagina != null) {
            int i;
            for (i = 0; i < pagina.tamanho; i++) {
                if (!pagina.isFolha) {
                    imprimirNaOrdem(pagina.filhos[i]);
                }
                System.out.print(pagina.chaves[i] + " ");
            }
//                if (!pagina.isFolha) {
//                    imprimirNaOrdem(pagina.filhos[i]);
//                }
        }
    }

    // Função para remover uma chave da árvore B
    public void remove(int chave) {
        remove(root, chave);
    }

    private void remove(Pagina pagina, int chave) {
        if (pagina == null)
            return;

        int indice = encontrarIndiceChave(pagina, chave);

        if (indice < pagina.tamanho && pagina.chaves[indice] == chave) {
            if (pagina.isFolha) {
                removeChaveFolha(pagina, indice);
            } else {
                removeChaveNaoFolha(pagina, indice);
            }
        } else {
            if (pagina.isFolha) {
                System.out.println("A chave " + chave + " não está presente na árvore.");
                return;
            }

            boolean isLastChild = (indice == pagina.tamanho);

            if (pagina.filhos[indice].tamanho < 2) {
                balancear(pagina, indice);
            }

            if (isLastChild && indice > pagina.tamanho) {
                remove(pagina.filhos[indice - 1], chave);
            } else {
                remove(pagina.filhos[indice], chave);
            }
        }
    }

    private int encontrarIndiceChave(Pagina pagina, int chave) {
        int indice = 0;
        while (indice < pagina.tamanho && chave > pagina.chaves[indice]) {
            indice++;
        }
        return indice;
    }

    private void removeChaveFolha(Pagina pagina, int indice) {
        for (int i = indice + 1; i < pagina.tamanho; i++) {
            pagina.chaves[i - 1] = pagina.chaves[i];
        }
        pagina.tamanho--;
    }

    private void removeChaveNaoFolha(Pagina pagina, int indice) {
        int chave = pagina.chaves[indice];

        if (pagina.filhos[indice].tamanho >= 2) {
            int predecessor = getPredecessor(pagina.filhos[indice]);
            pagina.chaves[indice] = predecessor;
            remove(pagina.filhos[indice], predecessor);
        } else if (pagina.filhos[indice + 1].tamanho >= 2) {
            int successor = getSuccessor(pagina.filhos[indice + 1]);
            pagina.chaves[indice] = successor;
            remove(pagina.filhos[indice + 1], successor);
        } else {
            juntar(pagina, indice);
            remove(pagina.filhos[indice], chave);
        }
    }

    private int getPredecessor(Pagina pagina) {
        while (!pagina.isFolha) {
            pagina = pagina.filhos[pagina.tamanho];
        }
        return pagina.chaves[pagina.tamanho - 1];
    }

    private int getSuccessor(Pagina pagina) {
        while (!pagina.isFolha) {
            pagina = pagina.filhos[0];
        }
        return pagina.chaves[0];
    }

    private void balancear(Pagina pagina, int indice) {
        if (indice != 0 && pagina.filhos[indice - 1].tamanho >= 2) {
            preencherAnterior(pagina, indice);
        } else if (indice != pagina.tamanho && pagina.filhos[indice + 1].tamanho >= 2) {
            preencherProximo(pagina, indice);
        } else {
            if (indice != pagina.tamanho) {
                juntar(pagina, indice);
            } else {
                juntar(pagina, indice - 1);
            }
        }
    }

    private void preencherAnterior(Pagina pagina, int indice) {
        Pagina filhoX = pagina.filhos[indice];
        Pagina filhoY = pagina.filhos[indice - 1];

        for (int i = filhoX.tamanho - 1; i >= 0; i--) {
            filhoX.chaves[i + 1] = filhoX.chaves[i];
        }

        if (!filhoX.isFolha) {
            for (int i = filhoX.tamanho; i >= 0; i--) {
                filhoX.filhos[i + 1] = filhoX.filhos[i];
            }
        }

        filhoX.chaves[0] = pagina.chaves[indice - 1];

        if (!filhoX.isFolha) {
            filhoX.filhos[0] = filhoY.filhos[filhoY.tamanho];
        }

        pagina.chaves[indice - 1] = filhoY.chaves[filhoY.tamanho - 1];

        filhoX.tamanho++;
        filhoY.tamanho--;
    }

    private void preencherProximo(Pagina pagina, int indice) {
        Pagina filhoX = pagina.filhos[indice];
        Pagina filhoY = pagina.filhos[indice + 1];

        filhoX.chaves[filhoX.tamanho] = pagina.chaves[indice];

        if (!filhoX.isFolha) {
            filhoX.filhos[filhoX.tamanho + 1] = filhoY.filhos[0];
        }

        pagina.chaves[indice] = filhoY.chaves[0];

        for (int i = 1; i < filhoY.tamanho; i++) {
            filhoY.chaves[i - 1] = filhoY.chaves[i];
        }

        if (!filhoY.isFolha) {
            for (int i = 1; i <= filhoY.tamanho; i++) {
                filhoY.filhos[i - 1] = filhoY.filhos[i];
            }
        }

        filhoX.tamanho++;
        filhoY.tamanho--;
    }

    private void juntar(Pagina pagina, int indice) {
        Pagina filhoX = pagina.filhos[indice];
        Pagina filhoY = pagina.filhos[indice + 1];

        filhoX.chaves[2] = pagina.chaves[indice];

        for (int i = 0; i < filhoY.tamanho; i++) {
            filhoX.chaves[i + 3] = filhoY.chaves[i];
        }

        if (!filhoX.isFolha) {
            for (int i = 0; i <= filhoY.tamanho; i++) {
                filhoX.filhos[i + 3] = filhoY.filhos[i];
            }
        }

        for (int i = indice + 1; i < pagina.tamanho; i++) {
            pagina.chaves[i - 1] = pagina.chaves[i];
        }

        for (int i = indice + 2; i <= pagina.tamanho; i++) {
            pagina.filhos[i - 1] = pagina.filhos[i];
        }

        filhoX.tamanho += filhoY.tamanho + 1;
        pagina.tamanho--;
    }

    public void limpar() {
        limpar(root);
        root = new Pagina(true);
    }

    private void limpar(Pagina pagina) {
        if (pagina != null) {
            if (!pagina.isFolha) {
                for (int i = 0; i <= pagina.tamanho; i++) {
                    limpar(pagina.filhos[i]);
                }
            }
            pagina = null;
        }
    }

    public boolean contem(int chave) {
        return contem(root, chave);
    }

    private boolean contem(Pagina pagina, int chave) {
        if (pagina == null) {
            return false;
        }

        int i = 0;
        while (i < pagina.tamanho && chave > pagina.chaves[i]) {
            i++;
        }

        if (i < pagina.tamanho && chave == pagina.chaves[i]) {
            return true;
        }

        if (pagina.isFolha) {
            return false;
        }

        return contem(pagina.filhos[i], chave);
    }

}
