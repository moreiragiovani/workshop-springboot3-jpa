package com.cursospring.br.enums;

public enum PedidoStatus {
	PAGAMENTO_EM_ESPERA(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int code;
	
	private PedidoStatus(int code) {
		this.code = code;
	}
	
	public int getCode () {
		return code;
	}
	
	public static PedidoStatus valueOf(int code) {
		for(PedidoStatus value: PedidoStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Status do pedido invalido");
	}
}
