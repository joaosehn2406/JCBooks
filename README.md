# 📚 App Favoritos de Livros

<div align="center">
  <strong>Aplicativo Android desenvolvido em Kotlin com XML, onde você pode explorar livros e marcar seus favoritos!</strong>
</div>

<div align="center">
  <img src="https://img.shields.io/badge/Kotlin-Android-blueviolet?style=for-the-badge&logo=kotlin"/>
  <img src="https://img.shields.io/badge/XML-Layout-orange?style=for-the-badge&logo=xml"/>
  <img src="https://img.shields.io/badge/MVVM-Architecture-green?style=for-the-badge"/>
</div>

---

## 📖 Índice

- [🔍 Visão Geral](#-visão-geral)
- [📱 Funcionalidades](#-funcionalidades)
- [📐 Estrutura do Projeto](#-estrutura-do-projeto)
- [🛠️ Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [🚀 Como Executar](#-como-executar)
- [🤝 Contribuição](#-contribuição)
- [📄 Licença](#-licença)

---

## 🔍 Visão Geral

Este aplicativo Android permite ao usuário visualizar uma lista de livros e marcar seus favoritos. Cada livro pode ser selecionado para exibir mais detalhes, como o nome do autor.

O objetivo do projeto é demonstrar o uso de **Kotlin com XML**, seguindo boas práticas de desenvolvimento Android, como **separação de responsabilidades** e **uso de arquitetura MVVM**.

---

## 📱 Funcionalidades

✔️ Visualizar uma **lista de livros disponíveis**

✔️ **Favoritar ou desfavoritar** um livro com apenas um toque

✔️ Ver uma **lista exclusiva com os livros favoritos**

✔️ Acessar **detalhes do livro**, como o nome e o autor

✔️ Interface **simples, funcional e responsiva**

---

## 📐 Estrutura do Projeto

- `MainActivity`: Tela principal com navegação entre listas
- `BookAdapter`: Adapter da RecyclerView para listar os livros
- `BookViewModel`: Gerencia os estados da lista e favoritos
- `Book`: Classe de dados que representa um livro
- `FragmentList`, `FragmentFavorites`, `FragmentDetails`: Fragments separados para cada funcionalidade
- Navegação com **BottomNavigationView** para alternar entre telas

---

## 🛠️ Tecnologias Utilizadas

- **Kotlin**
- **XML** (layouts)
- **RecyclerView**
- **Fragments**
- **ViewModel + LiveData**
- **BottomNavigationView**

---

## 🚀 Como Executar

### Pré-requisitos

- Android Studio instalado
- Emulador configurado ou dispositivo físico conectado

### Passos

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/joaosehn2406/app-lista-livros.git
   ```

2. **Abra o projeto no Android Studio**

3. **Execute o app** com o botão "Run" ou selecione um emulador/dispositivo

---

## 🤝 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch: `git checkout -b minha-feature`
3. Commit suas alterações: `git commit -m 'feat: nova feature'`
4. Push na sua branch: `git push origin minha-feature`
5. Abra um Pull Request

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja mais em [LICENSE](https://mit-license.org/).

---

**Desenvolvido com 💜 em Kotlin para quem ama livros e código!**
