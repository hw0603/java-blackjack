package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.GameResultBoard;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.domain.card.Card;
import blackjack.domain.dto.PlayerDto;
import blackjack.domain.dto.PlayerResultDto;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class BlackJackController {
    public static final int INITIAL_CARDS_COUNT = 2;
    private final InputView inputView;
    private final OutputView outputView;

    public BlackJackController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Dealer dealer = new Dealer();
        Players players = Players.from(inputView.inputPlayerNames());
        Deck deck = Deck.createShuffledDeck();

        playGame(dealer, players, deck);
        printGameResult(dealer, players);
    }

    private void playGame(Dealer dealer, Players players, Deck deck) {
        doInitialDraw(dealer, players, deck);

        players.getPlayers().forEach(
                player -> doRound(player, deck)
        );
        doDealerRound(dealer, deck);
    }

    private void doInitialDraw(Dealer dealer, Players players, Deck deck) {
        players.initialDraw(deck, INITIAL_CARDS_COUNT);
        dealer.draw(deck, INITIAL_CARDS_COUNT);

        outputView.printInitialMessage(players.getPlayerNames());
        printInitialCards(dealer, players);
    }

    private void printInitialCards(Dealer dealer, Players players) {
        List<Card> dealerCards = dealer.getCards();
        outputView.printDealerInitialCard(dealerCards.get(0));

        List<PlayerDto> playerDtos = players.getPlayers().stream()
                .map(PlayerDto::from)
                .toList();
        outputView.printPlayerInitialCards(playerDtos);
    }

    private void doRound(Player player, Deck deck) {
        while (!player.isBusted() && hasAdditionalCardRequest(player)) {
            player.draw(deck);
            outputView.printPlayerCard(PlayerDto.from(player));
        }
    }

    private boolean hasAdditionalCardRequest(Player player) {
        return inputView.inputDrawChoice(player.getName());
    }

    private void doDealerRound(Dealer dealer, Deck deck) {
        dealer.drawUntilExceedMinimum(deck);
        outputView.printExtraDealerDraw(dealer.getExtraCardsCount(INITIAL_CARDS_COUNT));
    }

    private void printGameResult(Dealer dealer, Players players) {
        printCardStatus(dealer, players);
        GameResultBoard gameResultBoard = new GameResultBoard(dealer, players);

        outputView.printDealerResult(gameResultBoard.getDealerResult());
        for (Player player : players.getPlayers()) {
            outputView.printPlayerResult(player.getName(), gameResultBoard.getGameResult(player));
        }
    }

    private void printCardStatus(Dealer dealer, Players players) {
        PlayerResultDto dealerResult = PlayerResultDto.from(dealer.getPlayer());

        List<PlayerResultDto> playerResultDtos = players.getPlayers().stream()
                .map(PlayerResultDto::from)
                .toList();
        outputView.printCardStatus(dealerResult, playerResultDtos);
    }
}
