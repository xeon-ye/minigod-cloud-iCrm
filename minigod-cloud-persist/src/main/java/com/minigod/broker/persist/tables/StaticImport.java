package com.minigod.broker.persist.tables;

import com.minigod.db4j.common.DBContext;
import com.minigod.db4j.table.Tables;

public class StaticImport extends DBContext {

	public static final TBrokerAccountAsset tBrokerAccountAsset = Tables.get(TBrokerAccountAsset.class);
	public static final TBrokerAccountCollocation tBrokerAccountCollocation = Tables.get(TBrokerAccountCollocation.class);
	public static final TBrokerAccountDeposit tBrokerAccountDeposit = Tables.get(TBrokerAccountDeposit.class);
	public static final TBrokerAccountRelation tBrokerAccountRelation = Tables.get(TBrokerAccountRelation.class);
	public static final TBrokerCashAcc tBrokerCashAcc = Tables.get(TBrokerCashAcc.class);
	public static final TBrokerCashTransFlow tBrokerCashTransFlow = Tables.get(TBrokerCashTransFlow.class);
	public static final TBrokerUserInfo tBrokerUserInfo = Tables.get(TBrokerUserInfo.class);
	public static final TBrokerUserRelation tBrokerUserRelation = Tables.get(TBrokerUserRelation.class);
	public static final TBrokerWithdraw tBrokerWithdraw = Tables.get(TBrokerWithdraw.class);
	public static final TBrokerUserThirdInfo tBrokerUserThirdInfo = Tables.get(TBrokerUserThirdInfo.class);
}

