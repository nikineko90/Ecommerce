package com.generation.NegozioRossi.util;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public interface IMappablePro {

	default Map<String, String> toMap() {
		Map<String, String> ris = new HashMap<>();
		
		// getClass() restituisce la Classe dell'oggetto su cui viene invocato
		// il metodo toMap()
		// Class � un Generics. Non sto specificando il suo tipo ma gli sto solo dicendo
		// che la classe che descriver� sar� una che implementa IMappablePro
		Class<? extends IMappablePro> classe = getClass();
		// Come con ArrayList<String> il cui tipo sar� String
		// Class devo indicargli il tipo, ma non so quale sar�
		// Con questa sintassi ? extends IMappablePro vado a specificare che il tipo non lo conosco
		// precisamente (?) ma so che estender� IMappablePro (quindi come tipo formale sar� IMappablePro
		
		// Utilizzeremo l'API reflect che mi permette di operare sulla struttura della classe
		// Ho creato un vettore di Method (anche i metodi possono essere visti come oggetti)
		// contenente tutti i metodi di quella classe (ad es la classe Persona mi ritorner�
		// il costruttore, i getters e setters, il toString e altri metodi di base di Java
		Method[] metodi = classe.getMethods();
		
		// sto iterando il vettore dei metodi
		for (Method method : metodi) {
			// ho stampato il metodo stesso della classe
			
			// di questo metodo prendo solo il suo nome
			String methodName = method.getName();
//			System.out.println(methodName);
			
			// a me interessano solo i metodi getters perch� mi serviranno per prendere i valori
			// di quell'oggetto e assegnarli alla mappa
			if (!methodName.equalsIgnoreCase("getclass") && methodName.startsWith("get") || methodName.startsWith("is") ) {
//				System.out.println(methodName);
				
				try {
					// sto invocando il metodo
					// this indica l'oggetto su cui stiamo invocando il toMap
					// a me interessa il risultato trasformato in stringa
//					String valore = method.invoke(this).toString();
//					System.out.println(valore);
					
					// registro il return del metodo in un oggetto di tipo Object(padre di tutti)
					Object v = method.invoke(this);
					
					String valore = v == null ? "" : v.toString();
					// Devo fare questo perch� se la propriet� � un oggetto
					// ma questo non � stato assegnato, il suo valore � null
					// se invoco il toString su un null, questo mander� un'eccezione
					
					// questo indice mi servir� per "tagliare" via il get ad es da getId
					// oppure due lettere se � un boolean quindi isQualcosa
					int indiceDiPartenza = methodName.startsWith("get") ? 3 : 2;
					
					// con substring tolgo il get se parte con get e lo metto tutto in minuscolo
					// getId -> id
					// isQualcosa -> qualcosa
					String chiave = methodName.substring(indiceDiPartenza).toLowerCase();
//					System.out.println(chiave);
					
					ris.put(chiave, valore);
				} catch (IllegalAccessException |
						IllegalArgumentException |
						InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		// infine mi manca l'indicazione della classe.
		// banalmente metto alla chiave Class il semplice nome dell'oggetto classe
		// che abbiamo ottenuto all'inizio
		ris.put("Class", classe.getSimpleName());
		
		return ris;
	}
	
	default void fromMap(Map<String, String> map) {
		// registro la classe di appartenenza dell'oggetto su cui viene invocato il metodo
		Class<? extends IMappablePro> thisClass = getClass();
		
		// prendo i metodi della classe dell'oggetto e li salvo in un vettore di metodi
		Method[] metodi = thisClass.getMethods();
		
		for (Method metodo : metodi) {
			String nomeMetodo = metodo.getName();
			
			// controllo se il metodo inizia con set ad esempio setNome
			if (nomeMetodo.startsWith("set")) {
				// taglio via le prime tre lettere e metto tutto in minuscolo setNome -> nome
				String chiave = nomeMetodo.substring(3).toLowerCase();
				
				// dalla mappa che arriva da parametro prendo il valore associato alla chiave
				// esempio chiave nome : valore "Giovanni"
				String valore = map.get(chiave);
				
				// In pratica mi salvo la classe (di cui non conosco il tipo -> ?)
				// derivata dal primo parametro del metodo setter 
				// esempio void setNome(String nome)
				Class<?> tipoParametro = metodo.getParameterTypes()[0];
				
				try {
					// controllo se il parametro � di tipo char (i tipi dei parametri finiscono con .class)
					// nel caso invoco il metodo setter (as esempio setNome) passandogli come primo parametro
					// l'oggetto su cui stiamo lavorando e come secondo il valore trasformato in base
					// al tipo richiesto
					if (tipoParametro.equals(char.class)) {
						metodo.invoke(this, valore.charAt(0));
					} 
					// diventerebbe lunghissimo controllare tutti i tipi
//					else if (tipoParametro.equals(int.class)) {
//						metodo.invoke(this, Integer.parseInt(valore));
//					}
					// controllo se il tipo del parametro � primitivo (int, double, boolean, ecc)
					else if (tipoParametro.isPrimitive()){
						// creo un vettore del tipo primitivo del tipoParametro
						// tipoParametro = int -> vettore int[]
						// Array.get prende il valore in una determinata posizione (per noi la prima)
						// e lo trasforma automaticamente in boxato. Integer
						// mi basta poi prendere la sua classe
						Class<?> tipoBoxato = Array.get(Array.newInstance(tipoParametro, 1), 0).getClass();
						
						Method[] metodiBoxato = tipoBoxato.getMethods();
						
						for (Method metodoBoxato : metodiBoxato) {
							// controllo se il metodo inizia con parse
							if (metodoBoxato.getName().startsWith("parse") && metodoBoxato.getParameterCount() == 1) {
								// in tal caso invoco il metodo setter sull'oggetto
								// e come secondo parametro faccio il parsing del valore
								// lo invoco su null perch� � statico Integer.parseInt(valore)
								metodo.invoke(this, metodoBoxato.invoke(null, valore));
								break;
							}
						}
						
					} else {
						metodo.invoke(this, valore);
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
}