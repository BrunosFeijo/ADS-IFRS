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
        private void dividirFilhos(Pagina paginaX, int i) {
            Pagina paginaZ = new Pagina(paginaX.filhos[i].isFolha);
            Pagina paginaY = paginaX.filhos[i];
            paginaX.filhos[i] = paginaZ;

            for (int j = 2; j > i; j--) {
                paginaX.filhos[j] = paginaX.filhos[j - 1];
                paginaX.chaves[j] = paginaX.chaves[j - 1];
            }
            paginaX.chaves[i] = paginaY.chaves[2];
            paginaX.tamanho++;

            paginaZ.tamanho = 1;
            paginaZ.chaves[0] = paginaY.chaves[3];

            if (!paginaY.isFolha) {
                paginaZ.filhos[1] = paginaY.filhos[4];
                paginaZ.filhos[0] = paginaY.filhos[3];
            }

            paginaY.tamanho = 2;
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
                if (!pagina.isFolha) {
                    imprimirNaOrdem(pagina.filhos[i]);
                }
            }
        }

    // Função para remover uma chave da árvore B
    public void remove(int key) {
        remove(root, key);
    }

    private void remove(Pagina pagina, int chave) {
        if (pagina == null)
            return;

        int indice = findKeyindice(pagina, chave);

        if (indice < pagina.tamanho && pagina.chaves[indice] == chave) {
            if (pagina.isFolha) {
                removeKeyFromLeaf(pagina, indice);
            } else {
                removeKeyFromNonLeaf(pagina, indice);
            }
        } else {
            if (pagina.isFolha) {
                System.out.println("A chave " + chave + " não está presente na árvore.");
                return;
            }

            boolean isLastChild = (indice == pagina.tamanho);

            if (pagina.filhos[indice].tamanho < 2) {
                fill(pagina, indice);
            }

            if (isLastChild && indice > pagina.tamanho) {
                remove(pagina.filhos[indice - 1], chave);
            } else {
                remove(pagina.filhos[indice], chave);
            }
        }
    }

    private int findKeyindice(Pagina pagina, int chave) {
        int indice = 0;
        while (indice < pagina.tamanho && chave > pagina.chaves[indice]) {
            indice++;
        }
        return indice;
    }

    private void removeKeyFromLeaf(Pagina pagina, int indice) {
        for (int i = indice + 1; i < pagina.tamanho; i++) {
            pagina.chaves[i - 1] = pagina.chaves[i];
        }
        pagina.tamanho--;
    }

    private void removeKeyFromNonLeaf(Pagina pagina, int indice) {
        int key = pagina.chaves[indice];

        if (pagina.filhos[indice].tamanho >= 2) {
            int predecessor = getPredecessor(pagina.filhos[indice]);
            pagina.chaves[indice] = predecessor;
            remove(pagina.filhos[indice], predecessor);
        } else if (pagina.filhos[indice + 1].tamanho >= 2) {
            int successor = getSuccessor(pagina.filhos[indice + 1]);
            pagina.chaves[indice] = successor;
            remove(pagina.filhos[indice + 1], successor);
        } else {
            merge(pagina, indice);
            remove(pagina.filhos[indice], key);
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

    private void fill(Pagina pagina, int indice) {
        if (indice != 0 && pagina.filhos[indice - 1].tamanho >= 2) {
            borrowFromPrevious(pagina, indice);
        } else if (indice != pagina.tamanho && pagina.filhos[indice + 1].tamanho >= 2) {
            borrowFromNext(pagina, indice);
        } else {
            if (indice != pagina.tamanho) {
                merge(pagina, indice);
            } else {
                merge(pagina, indice - 1);
            }
        }
    }

    private void borrowFromPrevious(Pagina pagina, int indice) {
        Pagina child = pagina.filhos[indice];
        Pagina sibling = pagina.filhos[indice - 1];

        for (int i = child.tamanho - 1; i >= 0; i--) {
            child.chaves[i + 1] = child.chaves[i];
        }

        if (!child.isFolha) {
            for (int i = child.tamanho; i >= 0; i--) {
                child.filhos[i + 1] = child.filhos[i];
            }
        }

        child.chaves[0] = pagina.chaves[indice - 1];

        if (!child.isFolha) {
            child.filhos[0] = sibling.filhos[sibling.tamanho];
        }

        pagina.chaves[indice - 1] = sibling.chaves[sibling.tamanho - 1];

        child.tamanho++;
        sibling.tamanho--;
    }

    private void borrowFromNext(Pagina pagina, int indice) {
        Pagina child = pagina.filhos[indice];
        Pagina sibling = pagina.filhos[indice + 1];

        child.chaves[child.tamanho] = pagina.chaves[indice];

        if (!child.isFolha) {
            child.filhos[child.tamanho + 1] = sibling.filhos[0];
        }

        pagina.chaves[indice] = sibling.chaves[0];

        for (int i = 1; i < sibling.tamanho; i++) {
            sibling.chaves[i - 1] = sibling.chaves[i];
        }

        if (!sibling.isFolha) {
            for (int i = 1; i <= sibling.tamanho; i++) {
                sibling.filhos[i - 1] = sibling.filhos[i];
            }
        }

        child.tamanho++;
        sibling.tamanho--;
    }

    private void merge(Pagina pagina, int indice) {
        Pagina child = pagina.filhos[indice];
        Pagina sibling = pagina.filhos[indice + 1];

        child.chaves[2] = pagina.chaves[indice];

        for (int i = 0; i < sibling.tamanho; i++) {
            child.chaves[i + 3] = sibling.chaves[i];
        }

        if (!child.isFolha) {
            for (int i = 0; i <= sibling.tamanho; i++) {
                child.filhos[i + 3] = sibling.filhos[i];
            }
        }

        for (int i = indice + 1; i < pagina.tamanho; i++) {
            pagina.chaves[i - 1] = pagina.chaves[i];
        }

        for (int i = indice + 2; i <= pagina.tamanho; i++) {
            pagina.filhos[i - 1] = pagina.filhos[i];
        }

        child.tamanho += sibling.tamanho + 1;
        pagina.tamanho--;
    }

}
