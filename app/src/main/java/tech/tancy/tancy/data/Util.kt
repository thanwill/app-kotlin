package tech.tancy.tancy.data

class Util {

    companion object {
        fun validarEmail(email: String): Boolean {
            if (email.contains("@") && email.contains(".")) {
                return true
            }
            return false
        }

        fun validarSenha(senha: String): Boolean {
            if (senha.length >= 6) {
                return true
            }
            return false
        }

        fun validarNome(nome: String): Boolean {
            if (nome.length >= 3) {
                return true
            }
            return false
        }

        fun validarData(data: String): Boolean {
            if (data.length == 10) {
                return true
            }
            return false
        }

        fun validarHora(hora: String): Boolean {
            if (hora.length == 5) {
                return true
            }
            return false
        }

        fun validarDescricao(descricao: String): Boolean {
            if (descricao.length >= 10) {
                return true
            }
            return false
        }

        fun validarCompromisso(compromisso: Compromissos): Boolean {
            if (validarNome(compromisso.titulo) && validarDescricao(compromisso.descricao) && validarData(compromisso.data) && validarHora(compromisso.horaInicio) && validarHora(compromisso.horaFim)) {
                return true
            }
            return false
        }

        fun validarCompromissoEditado(compromisso: Compromissos): Boolean {
            if (validarNome(compromisso.titulo) && validarDescricao(compromisso.descricao) && validarData(compromisso.data) && validarHora(compromisso.horaInicio) && validarHora(compromisso.horaFim)) {
                return true
            }
            return false
        }

        fun validarCompromissoAdicionado(compromisso: Compromissos): Boolean {
            if (validarNome(compromisso.titulo) && validarDescricao(compromisso.descricao) && validarData(compromisso.data) && validarHora(compromisso.horaInicio) && validarHora(compromisso.horaFim)) {
                return true
            }
            return false
        }
    }
}