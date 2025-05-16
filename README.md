# but-there-is-coffee

## casos de uso:

-   como usuario não logado, quero ver todos os laboratórios que posso me cadastrar
-   como usuario não logado, quero verificar em quais laboratórios o meu email está cadastrado
-   como usuario não logado, quero cadastrar meu email em um determinado laboratório
-   como usuario não logado, quero remover meu email da lista de transmissão de determinados laboratórios, recebendo um email de confirmação

---

-   como admin não logado, quero logar como admin
-   como admin, quero alterar informações do meu cadastro
-   como admin, quero ver todos os laboratórios (que tenho autorização)
-   como admin, quero atualizar as informações de determinado laboratório (que tenho autorização)
-   como admin, quero cadastrar um novo botão e gerar um token para ele em determinado laboratório (que tenho autorização).
-   como admin, quero ver todos os botões existentes em determinado laboratório (que tenho autorização).
-   como admin, quero excluir um botão existente em determinado laboratório (que tenho autorização).
-   como admin, quero ver todos os cadastros em determinado laboratório (que tenho autorização)
-   como admin, quero remover um cadastro em determinado labotarório (que tenho autorização)
-   como admin, quero ver todas as solicitações de cadastro em determinado laboratório (que tenho autorização)
-   como admin, quero aceitar ou recusar as solicitações de cadastro em determinado laboratório (que tenho autorização)

---

-   como superAdmin, quero herdar tudo que um usuario pode fazer e possuo autorização em todos os laboratórios cadastrados
-   como superAdmin, quero cadastrar um novo usuario
-   como superAdmin, quero ver todos os usuarios
-   como superAdmin, quero adicionar/remover as autorizações de determinado usuario
-   como superAdmin, quero excluir um usuario existente
-   como superAdmin, quero cadastrar um novo laboratório
-   como superAdmin, quero excluir um laboratório existente

---

-   user:

    -   id: string (unique)
    -   email: string (unique)

-   admin:

    -   id: string (unique)
    -   email: string (unique)
    -   password: string
    -   adminGroups: string[] (group.id)
    -   isSuperAdmin: boolean

-   group:

    -   id: string (unique)
    -   name: string
    -   description: string
    -   users: string[] (user.id)

-   triggers:
    -   id: string (unique)
    -   name: string
    -   description: string
