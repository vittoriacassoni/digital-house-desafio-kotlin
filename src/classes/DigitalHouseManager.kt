package classes

class DigitalHouseManager {
    private val alunos = mutableMapOf<Int, Aluno>()
    private val professores = mutableMapOf<Int, Professor>()
    private val cursos = mutableMapOf<Int, Curso>()
    private val matriculas = mutableSetOf<Matricula>()

    //region Curso
    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int){
        try{
            if(!cursos.containsKey(codigoCurso)){
                var curso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)
                cursos[curso.codigo] = curso
                println("Curso registrado com sucesso ------------------------------------------")
            } else{
                throw Exception("Já existe um curso com esse código!")
            }
        }catch (erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
        }
    }

    fun excluirCurso(codigoCurso: Int){
        try{
            if(cursos.containsKey(codigoCurso)) {
                cursos.remove(codigoCurso)
                println("Curso excluido com sucesso ------------------------------------------")
            }else{
                throw Exception("Curso não existe")
            }
        }catch (erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
        }
    }

    //endregion

    //region Professor
    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int,
                                  quantidadeDeHoras: Int){
        try{
            if(!professores.containsKey(codigoProfessor)){
                var professorAdjunto = ProfessorAdjunto(nome, sobrenome, codigoProfessor, quantidadeDeHoras)
                professores[professorAdjunto.codigo] = professorAdjunto
                println("Professor Adjunto registrado com sucesso ------------------------------------------")
            } else{
                throw Exception("Já existe um professor com esse código!")
            }
        }catch (erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
        }
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int,
                                  especialidade: String ){
        try{
            if(!professores.containsKey(codigoProfessor)){
                var professorTitular = ProfessorTitular(nome, sobrenome, codigoProfessor, especialidade)
                professores[professorTitular.codigo] = professorTitular
                println("Professor Titular registrado com sucesso ------------------------------------------")
            } else{
                println("Já existe um professor com esse código!")
            }
        }catch (erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
        }
    }

    fun excluirProfessor(codigoProfessor: Int){
        try{
            if(professores.containsKey(codigoProfessor)) {
                professores.remove(codigoProfessor)
                println("Professor excluido com sucesso ------------------------------------------")
            }else{
                throw Exception("Professor não existe")
            }
        }catch (erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
        }
    }

    //endregion

    //region Aluno
    //Registrar aluno
    fun matricularAluno(nome: String , sobrenome: String , codigoAluno: Int){
        try{
            if(!alunos.containsKey(codigoAluno)){
                var aluno = Aluno(nome, sobrenome, codigoAluno)
                alunos[aluno.codigo] = aluno
                println("Aluno registrado com sucesso ------------------------------------------")
            } else{
                println("Já existe um aluno com esse código!")
            }
        }catch (erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
        }
    }
    //endregion

    //region Matricula
    //Matricular de fato aluno em um curso
    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        try{
            var alunoParaMatricular = alunos[codigoAluno]
            var cursoParaMatricular = cursos[codigoCurso]

            if(cursoParaMatricular != null){
                if(alunoParaMatricular != null){
                    if(cursoParaMatricular.adicionarUmAluno(alunoParaMatricular)) {
                        var matricula = Matricula(alunoParaMatricular!!, cursoParaMatricular!!)
                        matriculas.add(matricula)
                        println("Matrícula realizada com sucesso ------------------------------------------")
                    }else{
                        println("Não há vagas disponíveis nesse curso -------------------------------------")
                    }
                } else{
                    throw Exception("Aluno não existe")
                }
            } else{
                throw Exception("Curso não existe")
            }
        }catch (erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
        }
    }

    //endregion

    //region Curso e Professor
    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        try{
            var professorTitular = professores[codigoProfessorTitular]
            var professorAdjunto = professores[codigoProfessorAdjunto]
            var curso = cursos[codigoCurso]

            if (curso != null) {
                if(professorAdjunto != null){
                    if(professorAdjunto is ProfessorAdjunto) {
                        curso.professorAdjunto = professorAdjunto!!
                        println("Professor Adjunto alocado com sucesso ------------------------------------------")
                    }else{
                        throw Exception("Informe o código de um Professor Adjunto!")
                    }
                }else{
                    throw Exception("Professor Adjunto não existe")
                }

                if(professorTitular != null){
                    if(professorTitular is ProfessorTitular) {
                        curso.professorTitular = (professorTitular as ProfessorTitular?)!!
                        println("Professor Titular alocado com sucesso ------------------------------------------")
                    }else{
                        throw Exception("Informe o código de um Professor Titular!")
                    }
                }else{
                    throw Exception("Professor Titular não existe")
                }
            }else{
                throw Exception("Curso não existe")
            }
        }catch(erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
        }
    }
    //endregion
}