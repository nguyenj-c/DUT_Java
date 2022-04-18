package java.fr.univ_amu.iut.exercice3;


public class ConvertisseurDeNombreRomain {
    public int enNombreArabe(String nombreRomain) {
        int nombreArabe = 0;
        for (int i = 0; i < nombreRomain.length(); ++i) {
            switch (nombreRomain.charAt(i)) {
                case 'I': {
                    int j = i;
                    while (j < nombreRomain.length() && nombreRomain.charAt(j) == 'I')
                        ++j;


                    int nombreDeI = j - i;


                    if (j < nombreRomain.length()) {
                        if (nombreRomain.charAt(j) == 'V')
                            nombreArabe += 5 - nombreDeI;
                        else if (nombreRomain.charAt(j) == 'X')
                            nombreArabe += 10 - nombreDeI;
                        else
                            throw new IllegalArgumentException();


                        i = j;
                    } else {
                        nombreArabe += nombreDeI;
                        i = j - 1;
                    }




                    break;
                }


                case 'V':
                    nombreArabe += 5;
                    if (i+1 < nombreRomain.length() && nombreRomain.charAt(i+1) != 'I')
                        throw new IllegalArgumentException();
                    break;


                case 'X': {
                    int j = i;
                    while (j < nombreRomain.length() && nombreRomain.charAt(j) == 'X')
                        ++j;


                    int nombreDeX = j - i;


                    if (j < nombreRomain.length()) {
                        if (nombreRomain.charAt(j) == 'L') {
                            nombreArabe += 50 - nombreDeX * 10;
                            i = j;
                            break;
                        }


                        else if (nombreRomain.charAt(j) == 'C') {
                            nombreArabe += 100 - nombreDeX * 10;
                            i = j;
                            break;
                        }


                        else if (nombreRomain.charAt(j) != 'V' && nombreRomain.charAt(j) != 'I')
                            throw new IllegalArgumentException();
                    }


                    nombreArabe += nombreDeX * 10;
                    i = j - 1; // le nombre en j doit être traité


                    break;
                }


                case 'L':
                    nombreArabe += 50;
                    break;


                case 'C':
                    nombreArabe += 100;
                    break;


                case 'D':
                    nombreArabe += 500;
                    break;


                case 'M':
                    nombreArabe += 1000;
                    break;
                default:
                    throw new IllegalArgumentException(nombreRomain.charAt(i) + " ???");
            }
        }






        return nombreArabe;
    }
}
