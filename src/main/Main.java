package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static int qtdVida = 3; // essa variavel é global, para quantidade de vida
	private static String nomeJogador = null; // essa variavel é global, para o nome do jogador
	private static Scanner leitor = new Scanner(System.in);
	private static List<Perguntas> perguntas;
	private static boolean estaNaEsfinge;

	public static void main(String[] args) {
		menu();
	}

	// para o menu do jogo
	public static void menu() {
		perguntas = new ArrayList<>();
		int opcao;

		do {
			System.out.println("-----ESCARAVELHO RUBI-----");
			System.out.println();
			System.out.println("1 - Jogar");
			System.out.println("2 - Instruções");
			System.out.println("3 - Créditos");
			System.out.println("4 - Sair");
			System.out.print("\nEscolha opção: ");

			opcao = leitor.nextInt();
			System.out.println();

			switch (opcao) {
			case 1:
				System.out.println("1 - Fácil");
				System.out.println("2 - Média");
				System.out.println("3 - Difícil");
				System.out.print("\nSelecione a dificuldade: ");

				int dificuldade = leitor.nextInt();
				ajustarPerguntas(perguntas, dificuldade);
				Collections.shuffle(perguntas);

				jogo(perguntas); // Aqui vai chamar o metodo do inicio do jogo
				break;

			case 2:
				instrucoes(); // Aqui vai chamar o método da instruções
				break;

			case 3:
				creditos(); // Aqui vai chamar o método dos creditos
				break;

			case 4:
				System.out.println("\nObrigado por jogar!! *-*");
				break;

			}
		} while (opcao != 4); // laço para mostra mais vezes o menu

	}

	// essa função é para o jogador colocar o nome e uma pequena introdução do jogo,
	// e ja chama o metodo desafio para comecar o jogo
	public static void jogo(List<Perguntas> perguntas) {
		int escolha = 0;
		int resposta = 0;

		System.out.print("\n\nInsira o nome do jogador(a): ");
		nomeJogador = leitor.next();
		System.out.println("\n\nOlá " + nomeJogador + "!\n"
				+ "No jogo o escaravelho rubi, você terá que descobrir como e porque você foi parar naquela jornada,\n"
				+ "além de procurar o significado de sua busca. Nesse jogo vamos mostrar a sua evolução quantos os níveis de dificuldade dos Desafios.\n"
				+ "Eai, vamos começar os desafios, " + nomeJogador + "?");

		System.out.println("\n\nEra dia, por volta de Setembro de 1978, você se encontra perdido em meio a um deserto."
				+ "Você olha para os lados e vê apenas areia,\nmas forçando um pouco mais sua vista, enxerga longinquamente "
				+ "à esquerda uma lagoa e para trás de você, acha-se uma taverna. \n\nPara onde deseja ir?");
		System.out.println("\n1 - Em direção à lagoa");
		System.out.println("2 - Em direção à taverna\n");

		System.out.print("Resposta: ");
		escolha = leitor.nextInt();

		if (escolha == 1) {
			System.out.println("\n\nSeguiremos então para a lagoa!\n\n\n");
			System.out.println("Depois de muito caminhar e nunca chegar à tal lagoa, você morre de sede.\n\n");
			System.out.println("Dica: cuidado com as miragens, elas podem fazer com que você morra imediatamente.");
		} else if (escolha == 2) {
			System.out.println("\n\nSeguiremos então para a taverna!");
			System.out.println("Depois de caminhar por volta de 35 minutos, você chega ao lugar desejado.\n\n"
					+ "Morrendo de sede e sem uma gota de água sequer, você entra desesperado na taverna.\n\n"
					+ "Todos param ao te ver entrar bruscamente.\n\nUm homem se aproxima e pergunta se deseja algo. "
					+ "O que você responde?");
			System.out.println("\n1 - Pede um copo de água");
			System.out.println("2 - Pede comida");
			System.out.println("3 - Pede uma informação");
			System.out.print("\nResposta: ");
			escolha = leitor.nextInt();

			if (escolha == 1) {
				do {
					System.out.println(
							"O bom senhor responde que lhe dará água apenas se acertar uma pergunta que ele fará.\n");
					System.out.println("Sem mais opções, você aceita a proposta! Logo o senhor faz a pergunta:\n");
					System.out.println("\"" + perguntas.get(0).getPergunta() + "\" \n");
					System.out.println(
							"Para lhe facilitar a resposta o bom senhor lhe dá alternativas para responder a pergunta:\n");
					System.out.println(perguntas.get(0).getAlternativasEmString());
					System.out.print("\nResposta: ");
					resposta = leitor.nextInt(); // lê a resposta do usuário

				} while (verificacao(perguntas.get(0), resposta));

				System.out.println("\n\nO bom senhor grita aos quatro cantos: \"VIVA! Finalmente alguém sábio\".\n"
						+ "Ele lhe dá o copo d'água. Você bebe e já não sente mais aquela sede de antes.\n\n"
						+ "Memórias começam a voltar para a sua mente... Você se lembra do seu objetivo e de uma busca que você fazia.\n"
						+ "Você estava atrás do famoso Escaravelho Rubi. Alguns tentaram lhe desanimar, falavam que não existia, mas você não abaixava a cabeça.\n"
						+ "Você decide investigar sobre. O que fazer agora?\n\n"
						+ "1 - Perguntar sobre o Escaravelho para as pessoas no bar.\n"
						+ "2 - Pedir a informação que o bom senhor iria lhe passar.\n"
						+ "3 - Sair sem rumo da taverna e correr em linha reta.\n");
				System.out.print("Resposta: ");
				escolha = leitor.nextInt();

				if (escolha == 1) {
					System.out
							.println("Você pergunta para algumas pessoas sobre o Escaravelho e é zombado e insultado.\n"
									+ "Ao insistir em perguntar, as pessoas do bar se irritam e começam a jogar pedras em você.\n\nVocê morre depois de hemorragia interna.\n\n");
					fimDeJogo();
					System.exit(0);
				} else if (escolha == 2) {
					do {
						System.out.println(
								"\n\nO bom senhor lhe diz que falará tudo que sabe se conseguir responder a mais um de seus enigmas.\n"
										+ "Se vendo novamente sem mais opções, você aceita.\n\n"
										+ "Logo, o bom senhor lhe diz:\n" + "\n\"" + perguntas.get(0).getPergunta()
										+ "\"\n\n" + "E novamente te dá 5 alternativas de resposta:\n\n"
										+ perguntas.get(0).getAlternativasEmString() + "\n");
						System.out.print("Resposta: ");
						resposta = leitor.nextInt(); // lê a resposta do usuário

					} while (verificacao(perguntas.get(0), resposta));

					System.out.println(
							"\n\nO bom senhor brada mais uma vez ao alto, dizendo: \"IHAAA! Rapaz, sabia que você era bom, viu! Mas não sabia que você era o melhor.\""
									+ "\n\nVocê se felicita com o brado do senhor e exige mais informações sobre o Escaravelho Rubi.\n\n"
									+ "Quando o senhor tomou iniciativa para falar, de repente um servo do Faraó entra desesperado na taverna e anuncia:\n"
									+ "\"EI! Você! O grande Faraó solicita a sua presença no palácio IMEDIATAMENTE!\"\n\n"
									+ "Você fica assustado porque foi encontrado, mas insiste em continuar com a sua busca.\n O servo mais uma vez tenta lhe convencer e você o ignora, esperando"
									+ "que ele vá embora.\n\nO Servo então lhe dá condição, caso você acerte uma questão, ele irá embora, lhe dando mais 2 noites para continuar com sua busca.\n\n"
									+ "Você aceita o desafio bravamente. Portanto o servo lhe pergunta:\n" + "\""
									+ perguntas.get(0).getPergunta() + "\"\n\n"
									+ perguntas.get(0).getAlternativasEmString() + "\n");
					System.out.print("Resposta: ");
					resposta = leitor.nextInt(); // lê a resposta do usuário
					if (!verificacao(perguntas.get(0), resposta)) {
						System.out.println(
								"\nO servo fica surpreso por você conseguir acertar e ganhar a condição proposta. \n"
										+ "Ele te lembra que tem mais 2 noites para sua busca e se não retornar, ele vai te achar onde estiver e te buscar a força.\n\n"
										+ "Depois do servo zarpar da taverna, o bom senhor, impressionado com sua sabedoria, ele te dá as informações que precisa, juntamente com uma bolsa com alimentos, água, para sobreviver durante a jornada. Luneta"
										+ "e um mapa com a esfinge mais próxima. Agradecido pela generosidade do bom senhor, você sai da taverna empolgado.\n\n"
										+ "No momento em que você começa a andar para a sua próxima jornada, o bom senhor, aos berros, lhe diz:"
										+ "\n\"ESPEEERA! Tenho algo para lhe ajudar a ir mais rápido! Mas, assim como nas outras vezes, terei que testá-lo.\" - diz ele trazendo um camelo.\n"
										+ "Você aceita a ajuda dele?\n\n" + "1 - Sim\n" + "2 - Não\n");
						System.out.print("Resposta: ");
						escolha = leitor.nextInt();

						if (escolha == 1) {

							do {
								System.out.println("\nO bom senhor então começa a perguntar:\n" + "\""
										+ perguntas.get(0).getPergunta() + "\"\n\n"
										+ perguntas.get(0).getAlternativasEmString() + "\n");
								System.out.print("Resposta: ");
								resposta = leitor.nextInt(); // lê a resposta do usuário
							} while (verificacao(perguntas.get(0), resposta));
							qtdVida = 1;
							estaNaEsfinge = true;
							System.out.println(
									"\nCom um grande sorriso e levando Camilo, o camelo, até você, o bom senhor diz:"
											+ "\n\"Parabéns meu jovem, leve este camelo com você! Ele será fiel a você durante toda a sua jornada. E tome cuidado!\""
											+ "\n\nVocê agradece o bom senhor, monta no camelo e finalmente começa a sua jornada."
											+ "\n\nApós 15 longas horas montado no Camilo, você finalmente chega à esfinge."
											+ "\n\n*!*Aqui começa a sua última parte da jornada. A partir daqui você terá apenas uma chance, esteja preparado. E que a sorte esteja sempre ao seu favor.*!*\n\n"
											+ "Você lê a escritura na porta da esfinge, que diz: \n\n\"litajawuz hdha albab, yjb ealayk halun hdha allaghaz.\"\n\n"
											+ "Você fica desesperado, pois não reconhecia aquela língua. Mas, ao revistar as bolsas do Camilo, o camelo, você acha um pergaminho que traduzia a frase:\n\n"
											+ "\"Para passar desta porta, você deve resolver este enigma:\"\n\n"
											+ "Traduzindo o enigma, você chega a:\n\n" + "\""
											+ perguntas.get(0).getPergunta() + "\"\n\n"
											+ perguntas.get(0).getAlternativasEmString() + "\n");
							System.out.print("Resposta: ");
							resposta = leitor.nextInt(); // lê a resposta do usuário
							if (!verificacao(perguntas.get(0), resposta)) {
								System.out.println(
										"\nA porta se abre, você entra e sente uma cobra passar pelo seu pé.\nAo se deparar com a cobra, você vê que há um caminho cheio delas e no outro caminho um corredor cheio de armadilhas.\n\n"
												+ "Como você tem pavor de agulhas, você segue em direção as cobras. \n\nUm pouco mais adiante, você avista uma mulher sentada em um trono e a reconhece como a Medusa. \n\n"
												+ "Imediatamente você fecha os olhos. Ela ao te ver em desespero, dá uma risada sarcástica e lhe diz:\n\n"
												+ "\"Homenzinho, lhe darei uma chance de passar por mim. Você terá que acertar doiss doss meuss enigmasss.\""
												+ "\n\nVocê sabe que essa é a única oportunidade e aceita seguir adiante.\n\n"
												+ "Logo, a mulher do cabelo de cobras lhe faz a primeira das perguntas: \n\n"
												+ "\"" + perguntas.get(0).getPergunta() + "\"\n\n"
												+ perguntas.get(0).getAlternativasEmString() + "\n");
								System.out.print("Resposta: ");
								resposta = leitor.nextInt(); // lê a resposta do usuário
								if (!verificacao(perguntas.get(0), resposta)) {
									System.out.println(
											"\nMedusa diz: \"Muito bem, muito bem! Agora... Vamoss para a ssegunda quesstão...\"\n\n"
													+ "\"" + perguntas.get(0).getPergunta() + "\"\n\n"
													+ perguntas.get(0).getAlternativasEmString() + "\n");
									System.out.print("Resposta: ");
									resposta = leitor.nextInt(); // lê a resposta do usuário
									if (!verificacao(perguntas.get(0), resposta)) {
										System.out.println(
												"\nMeuss parabénss homenzinho! Você conseguiu acertar ass perguntass... Siga em frente!"
														+ "\n\nVocê ouve as portas se abrirem e, ainda sem abrir os olhos, corre em direção ao barulho das portas.\n\n"
														+ "Ao entrar na próxima sala e finalmente ouvir as portas fecharem, você abre os olhos e percebe que está em uma sala escura, "
														+ "com apenas um ponto de luz.\n\nUsando a luneta, você consegue enxergar o belíssimo Escaravelho Rubi."
														+ "\n\nSeu coração começa a pulsar mais forte. Finalmente você o encontrou!! Apressadamente ao se aproximar, você vê que não será tão simples finalizar a sua jornada."
														+ "\n\nUm pedaço do chão se abre em sua frente e um muro sobe em torno do escaravelho simultaneamente, e você ouve uma voz semelhante a de um Deus dizendo:\n"
														+ "\"Para ser merecedor do Escaravelho Rubi, você deverá responder a mais 2 enigmas. Aqui vem o primeiro:\"\n\n"
														+ "Ao mesmo tempo do final da frase, você vê uma das perguntas surgir no solo. Em letras de lava, você lê: \n\n"
														+ "\"" + perguntas.get(0).getPergunta() + "\"\n\n"
														+ perguntas.get(0).getAlternativasEmString() + "\n");
										System.out.print("Resposta: ");
										resposta = leitor.nextInt(); // lê a resposta do usuário
										if (!verificacao(perguntas.get(0), resposta)) {
											System.out.println("\nVocê ouve aquele brado glorioso novamente:"
													+ "\n\"Muito bem, " + nomeJogador
													+ "! Você acertou o primeiro de meus desafios... Poderá chegar mais perto do muro para ler o próximo enigma.\"\n\n"
													+ "Dito isto, o chão coomeça a se reerguer e a lava começa a secar, deixando o caminho até o muro completamente livre.\n\n"
													+ "Você enxerga também letras de luz se formando no muro que está a sua frente. Nessas letras se lê:\n\n"
													+ "\"" + perguntas.get(0).getPergunta() + "\"\n\n"
													+ perguntas.get(0).getAlternativasEmString() + "\n");
											System.out.print("Resposta: ");
											resposta = leitor.nextInt(); // lê a resposta do usuário
											if (!verificacao(perguntas.get(0), resposta)) {
												System.out.println(
														"O muro começa a se recolher e o Escaravelho Rubi fica novamente dentro do seu campo de visão.\n\n"
																+ "O muro desce por completo.\n"
																+ "Você ainda não acredita que finalmente conseguiu.\n"
																+ "Chegando mais perto do altar, você percebe que a mesma luz que vinha do muro está em volta do escaravelho."
																+ "E, mais uma vez, ouve aquela voz divina: \n\n"
																+ "\"Achou que seria tão fácil me derrotar? HAHAHAHA! Você precisará responder corretamente a mais um enigma.\"\n\n"
																+ "E assim você vê uma figura de luz caminhando em volta do altar. Essa figura, ainda com a voz divina, lhe diz:\n\n"
																+ "\"" + perguntas.get(0).getPergunta() + "\"\n\n"
																+ perguntas.get(0).getAlternativasEmString() + "\n");
												System.out.print("Resposta: ");
												resposta = leitor.nextInt(); // lê a resposta do usuário
												if (!verificacao(perguntas.get(0), resposta)) {
													System.out.println("\"NÃAAOOOOO! IMPOSSÍVEL UM MORTAL GANHAR DE MIIIMMM...\" - exclama a figura de luz enquanto ela desaparece.\n"
															+ "Com a maior cautela, você se aproxima do Escarvelho Rubi. Não existe mais aquele campo de luz em volta dele.\n"
															+ "Você o pega e comemora que sua jornada não foi em vão... Logo, você escuta uma voz conhecida que diz:\n"
															+ "\"Bom trabalho garoto! Sabia que poderia confiar em você...\"\n"
															+ "Você se vira e encontra o bom senhor da taverna.\n"
															+ "Ele abre um sorriso enorme enquanto se transforma em uma forma de luz puríssima.\n\n"
															+ "Você o pergunta: \"Deus?? És tu?\"\n"
															+ "Ele o responde: \"Sim filho, eu sou Deus! A muito tempo espero alguém como você naquela taverna. Você tem futuro, aguarde para mais aventuras...\"");
												}else {
													System.out.println("Aquela figura de luz te direciona uma grande rajada de luz. Você queima até a morte.");
													fimDeJogo();
													System.exit(0);
												}
											} else {
												System.out.println(
														"As luzes que estavam no muro começam a ficar mais fortes, mais intensas e mais quentes. Você frita ao elas se concentrarem no seu peito!");
												fimDeJogo();
												System.exit(0);
											}
										} else {
											System.out.println(
													"O mar de lava começa a subir, subir e subir e você se vê totalmente afogado em lava.");
											fimDeJogo();
											System.exit(0);
										}
									} else {
										System.out.println(
												"Ao errar a questão, Medusa mente para você e o manda abrir os olhos para seguir o caminho. Ao abrir os olhos, você se depara com a Medusa em sua frente.");
										fimDeJogo();
										System.exit(0);
									}
								} else {
									System.out.println(
											"Ao errar a questão, Medusa manda uma jibóia rastejar até você, te estrangula até a morte.");
									fimDeJogo();
									System.exit(0);
								}
							} else {
								System.out.println(
										"Continuando de olhos fechados, você não percebe e é acertado por uma flecha em seu peito.");
								fimDeJogo();
								System.exit(0);
							}

						} else {
							System.out.println(
									"Você recusa a ajuda, alegando que o bom senhor já lhe ajudou demais. Você sai sozinho durante a jornada. Após andar pelo deserto por dois dias, "
											+ "o servo reaparece dizendo: \"Achou que eu estava brincando? Eu disse que se passasse 2 noites, eu te encontraria e te levava a força para o palácio!\" "
											+ "\nVocê tenta brigar, mas é derrotado pelo servo com uma pancada na cabeça, lhe amarrando pelos braços e pernas com uma corda e te levando de volta ao palácio.");
							fimDeJogo();
							System.exit(0);
						}

					} else {
						System.out.println("Ao errar a pergunta, o servo dá uma leve risada e diz:\n"
								+ "\"Sinto muito, " + nomeJogador
								+ ". Você vai imediatamente voltar ao palácio comigo!\"\nEntristecido, você sai da taverna com o servo a caminho de volta para o palácio.");
						fimDeJogo();
						System.exit(0);
					}
				} else if (escolha == 3) {
					System.out.println(
							"Você corre o mais rapido possível, sem rumo e sem pensar duas vezes, em menos de 2 horas você desmaia e perde a consciência.\n\n");
					fimDeJogo();
					System.exit(0);
				} else {
					System.out.println("Você fica indeciso e morre por conta da paranóia criada na sua cabeça.\n\n");
					fimDeJogo();
					System.exit(0);
				}

			} else if (escolha == 2) {
				System.out.println(
						"Ele te traz um bife que parece estar muito suculento, mas você não tem a chance nem de provar,\n"
								+ "pois você morre de sede antes dele finalizar o seu pedido.");
				System.out.println("\n\nDica: preste atenção aos detalhes, qualquer erro pode matá-lo!");
			} else if (escolha == 3) {
				System.out.println(
						"Ele te dá toda a informaçãque ele reuniu como trabalhador daquela taverna, mas não adianta de nada, pois você morreu de sede antes do primeiro fato.");
				System.out.println("\n\nDica: preste atenção aos detalhes, qualquer erro pode matá-lo!");
			}
		} else {
			System.out.println("Comando errado! Reinicie o jogo!");
			System.exit(0);
		}
	}

	// Aqui é para mostra a instruções do jogo
	public static void instrucoes() {
		System.out.println("Após clicar em jogar, você vai começar com 3 vidas para passar por 10 desafios. \n"
				+ "Tendo que escolher o nivel de dificuldade que será composta por: fácil, médio e difícil.\n"
				+ "E as perguntas decidirão se ele continua prosseguindo com a história caso acertar ou perderá a vida. \n"
				+ "Então você deverá fazer as escolhas e decisões corretas para conseguir avançar \n"
				+ "para objetivo do jogo. Mas como ja explicado tenha calma e muito cuidado, você vai encontrar difuculdades no seu caminho.\n"
				+ "Resolva os enigmas e conclua sua aventura. Tesouros lhe aguardam.\n\n"
				+ "Para voltar ao menu principal, digite voltar.");

		leitor.next();
		System.out.println();
	}

	// Nessa função vamos ver quantas questao foram acertadas ou erradas, e mostra
	// se o jogador tem vida
	public static boolean verificacao(Perguntas pergunta, int alternativaSelecionada) {
		// se retornar true, o jogador vai poder continuar jogando, e no momento que
		// tiver 0 não pode mais errar.

		if (pergunta.getResposta().equalsIgnoreCase(pergunta.getAlternativas().get(alternativaSelecionada - 1))) {
			perguntas.remove(pergunta);
			Collections.shuffle(perguntas);
			return false;
		} else {
			if (qtdVida > 1) {
				qtdVida--;
				System.out.println("\n\n-----Vida perdida-----\n");
				System.out.println("-----Vidas: " + qtdVida + "-----");
			} else if (!estaNaEsfinge) {
				fimDeJogo();
				System.exit(0);
			}
			return true;
		}
	}

	// Essa função é para mostra que o jogador perdeu todas as vidas
	public static void fimDeJogo() {
		System.out.println("Gamer Over");
		System.out.println("Que pena, " + nomeJogador + "! Não foi dessa vez...\n"
				+ "Mas vamos dar a volta por cima para encarar desafios ainda mais difíceis!! :)");
	}

	public static void creditos() {

	}

	private static void ajustarPerguntas(List<Perguntas> perguntas, int dificuldade) {
		if (dificuldade == 1) {
			Perguntas pergunta = new Perguntas();

			pergunta.setPergunta("Sr. Smith tem 4 filhas. Cada uma de suas filhas tem um irmão.\n "
					+ "Quantos filhos o Sr. Smith tem ao todo?");
			pergunta.setResposta("5");

			List<String> alternativas = new ArrayList<>();
			alternativas.add("5");
			alternativas.add("4");
			alternativas.add("6");
			alternativas.add("7");
			alternativas.add("8");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Somos 3 irmãos: José, Adriano e Caio.\nSabe-se que ou José é o mais velho ou Adriano é o mais novo.\n"
							+ "Sabe-se também que ou Adriano é o mais velho ou Caio é o mais velho."
							+ "\nQuem é o mais velho e o mais novo, respectivamente?");
			pergunta.setResposta("Caio e Adriano");

			alternativas = new ArrayList<>();
			alternativas.add("Caio e Adriano");
			alternativas.add("Adriano e José");
			alternativas.add("Caio e José");
			alternativas.add("José e Adriano");
			alternativas.add("Adriano e Caio");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"A mãe de Ana tem 5 filhas. Fafá, Fefê, Fifí, Fofó e mais uma.\nQual o nome da quinta filha?");
			pergunta.setResposta("Ana");

			alternativas = new ArrayList<>();
			alternativas.add("Fufu");
			alternativas.add("Clara");
			alternativas.add("Fernanda");
			alternativas.add("Ana");
			alternativas.add("Joana");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Se durante uma corrida de carros, você ultrapassa o segundo colocado. \nQual a sua posição atual?");
			pergunta.setResposta("Segundo");

			alternativas = new ArrayList<>();
			alternativas.add("Segundo");
			alternativas.add("Quarto");
			alternativas.add("Primeiro");
			alternativas.add("Terceiro");
			alternativas.add("Quinto");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Se meu pai é irmão da sua irmã. O que eu sou seu?");
			pergunta.setResposta("Sobrinho");

			alternativas = new ArrayList<>();
			alternativas.add("Tio");
			alternativas.add("Genro");
			alternativas.add("Sobrinho");
			alternativas.add("Filho");
			alternativas.add("Primo");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Uma mulher vai ao mercado. No caminho de ida, ela conta 10 árvores à sua direita.\n"
					+ "E no caminho de volta, ela conta 10 árvores à sua esquerda. Por quantas árvores ela passou naquele dia?");
			pergunta.setResposta("10");

			alternativas = new ArrayList<>();
			alternativas.add("20");
			alternativas.add("10");
			alternativas.add("15");
			alternativas.add("25");
			alternativas.add("5");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Uma borboleta vive 5 dias e a cada dia ela voa 4 metros. \nQuantos metros ela terá percorrido em 1 semana?");
			pergunta.setResposta("20");

			alternativas = new ArrayList<>();
			alternativas.add("28");
			alternativas.add("16");
			alternativas.add("22");
			alternativas.add("20");
			alternativas.add("24");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Uma lesma sobe 2 metros de uma parede por dia e por noite ela escorrega 1 metro.\n"
					+ "Levando em conta que ela está escalando uma parede de 20 metros, quantos dias serão necessários para escalar toda a parede?");
			pergunta.setResposta("19");

			alternativas = new ArrayList<>();
			alternativas.add("19");
			alternativas.add("20");
			alternativas.add("21");
			alternativas.add("18");
			alternativas.add("17");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Num carro entraram um avô, dois pais, dois filhos e um neto.\n"
					+ "Qual o número mínimo de pessoas no carro?");
			pergunta.setResposta("3");

			alternativas = new ArrayList<>();
			alternativas.add("1");
			alternativas.add("3");
			alternativas.add("5");
			alternativas.add("7");
			alternativas.add("9");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Se o amanhã de ontem era sexta-feira, que dia é o dia depois de amanhã de ontem?");
			pergunta.setResposta("Sábado");

			alternativas = new ArrayList<>();
			alternativas.add("Sexta");
			alternativas.add("Terça");
			alternativas.add("Quinta");
			alternativas.add("Domingo");
			alternativas.add("Sábado");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

		} else if (dificuldade == 2) {
			Perguntas pergunta = new Perguntas();

			pergunta.setPergunta("Atente-se para a expressão: \"C * (B – A) <= D – B / C.\"\n"
					+ "Qual seria o resultado da execução dessa expressão, caso o valor das variáveis fossem: A=3; B=6; C=2 e D=9 ?");
			pergunta.setResposta("true");

			List<String> alternativas = new ArrayList<>();
			alternativas.add("true");
			alternativas.add("false");
			alternativas.add("error");
			alternativas.add("9");
			alternativas.add("6");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Considerando os fundamentos de lógica de programação, considere as afirmativas abaixo:\n"
							+ "I - Toda expressão que possui um operador relacional, necessariamente, tem como resultado um valor do tipo “lógico”.\n"
							+ "II - As funções \"do-while\" e \"while\" são ambas de repetição.\n"
							+ "III - É adequado o uso de variáveis cujo tipo de dados seja “inteiro” para armazenar nomes de pessoas.\n");
			pergunta.setResposta("Apenas as afirmativas I e II são verdadeiras.");

			alternativas = new ArrayList<>();
			alternativas.add("Apenas a afirmativa I é verdadeira.");
			alternativas.add("Apenas as afirmativas I e II são verdadeiras.");
			alternativas.add("Todas são falsas.");
			alternativas.add("Apenas a afirmativa II é verdadeira.");
			alternativas.add("Todas são verdadeiras.");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Considere a sub-rotina abaixo:\n\n" + "1. Programa\n"
					+ "2. Declare X, Y e Z numérico\n" + "3. Leia X\n" + "4. Leia Y\n" + "5. Z:= (X + Y) x Y\n"
					+ "6. Escreva Z\n" + "7. Fim programa\n\n"
					+ "Supondo que o valor fornecido para X seja 3 e o valor fornecido para Y seja 4\n"
					+ "Qual o valor de Z?");
			pergunta.setResposta("28");

			alternativas = new ArrayList<>();
			alternativas.add("21");
			alternativas.add("28");
			alternativas.add("19");
			alternativas.add("36");
			alternativas.add("25");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Analise o seguinte programa:\n\n" + "int a = 5;\n" + "for(int i = 0; i <= 4; i++){\n"
					+ "  a += 3;\n" + "}\n" + "System.out.println(a)\n\n"
					+ "Ao final da execução desse programa, o valor impresso da variável a será:");
			pergunta.setResposta("Syntax error");

			alternativas = new ArrayList<>();
			alternativas.add("Syntax error");
			alternativas.add("20");
			alternativas.add("15");
			alternativas.add("24");
			alternativas.add("18");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Supondo que a cada semestre temos 2 provas, como faríamos o cálculo da média final?\n");
			pergunta.setResposta("media = (p1 + p2) /2");

			alternativas = new ArrayList<>();
			alternativas.add("media = p1 * p2 - 10");
			alternativas.add("media = p1/p2 + 10/2");
			alternativas.add("media = (p1-p2) * 2");
			alternativas.add("media = p1 + p2 /2");
			alternativas.add("media = (p1 + p2) /2");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Como se escreve a raiz quadrada de N no java?");
			pergunta.setResposta("Math.sqrt(N);");

			alternativas = new ArrayList<>();
			alternativas.add("Math.round(N);");
			alternativas.add("Math.sqrt(N);");
			alternativas.add("Math.pow(N,2);");
			alternativas.add("Math.random(N);");
			alternativas.add("Math.raizQuadrada(N);");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Como arredondar um número N em java?");
			pergunta.setResposta("Math.round(N);");

			alternativas = new ArrayList<>();
			alternativas.add("Math.sqrt(N);");
			alternativas.add("Math.round(N);");
			alternativas.add("Math.pow(N,2);");
			alternativas.add("Math.random(N);");
			alternativas.add("Math.arredondar(N);");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Como fazer a potenciação de N por X?");
			pergunta.setResposta("Math.pow(N,X);");

			alternativas = new ArrayList<>();
			alternativas.add("Math.sqrt(N,X);");
			alternativas.add("Math.round(N,X);");
			alternativas.add("Math.pow(N,X);");
			alternativas.add("Math.random(N,X);");
			alternativas.add("Math.potenciar(N,X);");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Para o que é usada a função \"do-while\"?");
			pergunta.setResposta("Repetição com verificação após a execução");

			alternativas = new ArrayList<>();
			alternativas.add("Repetição com verificação antes da execução");
			alternativas.add("Repetição com verificação após a execução");
			alternativas.add("Repetição sem verificação");
			alternativas.add("Repetição com verificação antes e depois da execução");
			alternativas.add("Nenhuma das alternativas");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Qual a utilidade do \"mod\"?");
			pergunta.setResposta("Retornar o resto da divisão de um número pelo outro");

			alternativas = new ArrayList<>();
			alternativas.add("Retornar o resultado da divisão de um número pelo outro");
			alternativas.add("Retornar o resultado da soma de um número ao outro");
			alternativas.add("Retornar o resto da divisão de um número pelo outro");
			alternativas.add("Retornar o resto da subtração de um número pelo outro");
			alternativas.add("Retornar o resultado da multiplicação de um número pelo outro");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

		} else if (dificuldade == 3) {
			Perguntas pergunta = new Perguntas();

			pergunta.setPergunta(
					"Um programador Java, na tentativa de armazenar quatro valores inteiros referentes a números de contas bancárias em um array, utilizou as instruções abaixo."
							+ "\nI- int [] contas = {1234, 3451, 2341, 3214};"
							+ "\nII- int contas = {1234, 3451, 2341, 3214};"
							+ "\nIII- int [] contas; contas = {1234, 3451, 2341, 3214};"
							+ "\nIV- contas = new int[4]; contas[1] = 1234; contas[2] = 3451; contas[3] = 2341; contas[4] = 3214;");
			pergunta.setResposta("I e III");

			List<String> alternativas = new ArrayList<>();
			alternativas.add("I e III");
			alternativas.add("II e IV");
			alternativas.add("III e IV");
			alternativas.add("I e II");
			alternativas.add("II, III e IV");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Dos trechos de códigos abaixo, extraídos de um arquivo fonte escrito para a versão 8 da linguagem Java, o único que compila corretamente é");
			pergunta.setResposta("public static void main(String args[]){}");

			alternativas = new ArrayList<>();
			alternativas.add("String x = (String) (b > c) ? \"true\" : \"false\"");
			alternativas.add("public static void main(String args[]){}");
			alternativas.add("final enum letra {A, B, C}");
			alternativas.add("Boolean bool = new Boolean()");
			alternativas.add("Integer inteiro[] = new List[]");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("São tipos primitivos da linguagem Java:");
			pergunta.setResposta("boolean, double, float e byte.");

			alternativas = new ArrayList<>();
			alternativas.add("int, string, long e real.");
			alternativas.add("char, int, real e bit.");
			alternativas.add("boolean, double, float e byte.");
			alternativas.add("real, short, long e char.");
			alternativas.add("string, long int, short int e float.");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Em Java 8, qual modificador de acesso torna um membro disponível somente para classes dentro do mesmo pacote ou subclasses?");
			pergunta.setResposta("protected");

			alternativas = new ArrayList<>();
			alternativas.add("public");
			alternativas.add("default");
			alternativas.add("private");
			alternativas.add("protected");
			alternativas.add("package-private");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Qual o resultado do código abaixo?\n" + "public class Desafio{" + "\n"
					+ "\tpublic static void main(String[] args){" + "\n" + "\t\tint value = 554;"
					+ "\n\t\tString var = (String)value; //linha 1" + "\n\t\tString temp= ''123'';"
					+ "\n\t\tint data = (int)temp; //linha 2" + "\n\t\tSystem.out.println(data+var);" + "\n\t}"
					+ "\n}");
			pergunta.setResposta("Erro de compilação devido as linhas 1 e 2");

			alternativas = new ArrayList<>();
			alternativas.add("Erro de compilação devido as linhas 1 e 2");
			alternativas.add("Erro de compilação devido à linha 1");
			alternativas.add("Erro de compilação devido à linha 2");
			alternativas.add("''554123''");
			alternativas.add("677");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Qual o resultado do código abaixo?\n\n" + "public class Desafio{\n" + "\n\n"
					+ "\tpublic static void main(String[] args){\n" + "\n\n"
					+ "\t\tList<Integer> elements = new ArrayList<>();\n" + "\n\t\telements.add(10);\n"
					+ "\n\t\tint firstElmnt = elements.get(1);\n" + "\n\t\tSystem.out.println(firstElmnt);\n"
					+ "\n\t}\n" + "\n}");
			pergunta.setResposta("Será lançada uma exceção IndexOutOfBoundsException em tempo de execução.");

			alternativas = new ArrayList<>();
			alternativas.add("0");
			alternativas.add("10");
			alternativas.add("null");
			alternativas.add("Será lançada uma exceção IndexOutOfBoundsException em tempo de execução.");
			alternativas.add("Será lançada uma exceção ArrayIndexOutOfBoundsException em tempo de execução.");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Observe o código a seguir na linguagem de programação Java.\n\n"
					+ "public class Exemplo{\n" + "\n\n" + "\tpublic static void main(String[] args){\n" + "\n\n"
					+ "\t\tfor(int count = 1; count <= 10; count++){\n" + "\n\t\t\tif(count % 2 == 0){\n"
					+ "\n\t\t\t\tSystem.out.printf(\"%d\", count);\n" + "\n\t\t\t}\n" + "\n\t}\n" + "\n}");
			pergunta.setResposta("2 4 6 8 10");

			alternativas = new ArrayList<>();
			alternativas.add("1 3 4 5 6 7 8 9 10");
			alternativas.add("2 4 6 8 10");
			alternativas.add("null");
			alternativas.add("1 3 5 7 9");
			alternativas.add("1");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("Considere os seguintes fragmentos de código Java:" + "\nI- int sum = 7; if(sum > 20){"
					+ "\nSystem.out.print(\"ganhou \");} else{"
					+ "\nSystem.out.print(\"perdeu \");} System.out.print(\"o bônus.\");" + "\n\n"
					+ "II- int sum = 21; if(sum != 20)" + "\nSystem.out.print(\"ganhou \"); else"
					+ "\nSystem.out.print(\"perdeu \"); System.out.print(\"o bônus.\");"
					+ "\n\nO resultado da execução dos fragmentos em I e II será, respectivamente,");
			pergunta.setResposta("perdeu o bônus e ganhou o bônus.");

			alternativas = new ArrayList<>();
			alternativas.add("ganhou e ganhou.");
			alternativas.add("perdeu e perdeu.");
			alternativas.add("perdeu o bônus e ganhou o bônus.");
			alternativas.add("perdeu o bônus e ganhou.");
			alternativas.add("perdeu e ganhou o bônus.");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta(
					"Assinale a alternativa INCORRETA acerca dos operadores lógicos da linguagem de programação Java.");
			pergunta.setResposta("são operadores de deslocamento de bits.");

			alternativas = new ArrayList<>();
			alternativas.add("são operadores de deslocamento de bits.");
			alternativas.add("~ é operador lógico de negação.");
			alternativas.add("&, |, ^ são operadores lógicos E, OU e OU-exclusivo");
			alternativas.add("==, != são operadores de igualdade e diferença.");
			alternativas.add("nenhuma das alternativas.");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);

			pergunta = new Perguntas();

			pergunta.setPergunta("public static double desafio() {\n"
					+ "\tSystem.out.println(\"Digite o numero a ser potenciado\");\n"
					+ "\tdouble X = scanner.nextDouble();\n" + "\tSystem.out.println();\n"
					+ "\tSystem.out.println(\"Digite a potência\");\n" + "\tdouble Z = scanner.nextInt();\n"
					+ "\tSystem.out.println();\n" + "\tdouble resultado = X;\n\n" + "\tif (Z == 0) {\n"
					+ "\t\treturn 0;\n" + "\t} else if (Z == 1) {\n" + "\t\treturn X;\n" + "\t} else {\n"
					+ "\t\tfor (int i = 1; i < Z; i++) {\n" + "\t\t\tresultado = resultado * X;\n" + "\t\t}\n"
					+ "\t\treturn resultado;\n" + "\t}\n" + "}"
					+ "\n\nSe X é igual a 3 e Z igual a 4, qual será o resultado?");
			pergunta.setResposta("81");

			alternativas = new ArrayList<>();
			alternativas.add("64");
			alternativas.add("27");
			alternativas.add("81");
			alternativas.add("243");
			alternativas.add("256");

			pergunta.setAlternativas(alternativas);
			perguntas.add(pergunta);
		}
	}

}

class Perguntas {
	private String pergunta;
	private String resposta;
	private List<String> alternativas;

	public Perguntas() {
		alternativas = new ArrayList<>();
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public List<String> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<String> alternativas) {
		this.alternativas = alternativas;
	}

	public String getAlternativasEmString() {
		Collections.shuffle(this.alternativas);

		return "1) " + this.alternativas.get(0) + "\n" + "2) " + this.alternativas.get(1) + "\n" + "3) "
				+ this.alternativas.get(2) + "\n" + "4) " + this.alternativas.get(3) + "\n" + "5) "
				+ this.alternativas.get(4);
	}
}